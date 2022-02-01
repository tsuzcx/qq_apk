package com.tencent.mobileqq.activity.qwallet.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.lyric.data.Character;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class KSongView
  extends FrameLayout
{
  private static final int MSG_UPDATE = 0;
  private static final int SCROLL_TIME = 50;
  public static final int STATE_COMPLETE = 3;
  public static final int STATE_PAUSED = 2;
  public static final int STATE_PLAYING = 1;
  public static final int STATE_READY = 0;
  public static final int STATE_UNINIT = -1;
  private static final String TAG = "KSongView";
  private static final int UPDATE_TIME = 50;
  private KSongTextView daoTxt;
  private int indexLine = 0;
  private KSongTextView ktv = null;
  private List<Sentence> list;
  private QwAdapter lvAdapter;
  private ListView lvListView;
  private KSHelper.Config mConfig = new KSHelper.Config();
  private KSongView.KHandler mHandler;
  private int mState = -1;
  private KSHelper.KListener mkl;
  private long pauseStart = 0L;
  private long pauseTime = 0L;
  private KSongProsBar prosBar;
  public long startTime;
  
  public KSongView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  private float getSentenceRate(int paramInt, long paramLong)
  {
    Object localObject = (Sentence)this.lvAdapter.getItem(paramInt);
    if ((localObject == null) || (((Sentence)localObject).jdField_b_of_type_JavaUtilArrayList.size() <= 0))
    {
      QLog.i("KSongView", 2, "error, sentence = " + localObject);
      return 0.0F;
    }
    if (paramLong >= ((Sentence)localObject).jdField_a_of_type_Long + ((Sentence)localObject).jdField_b_of_type_Long)
    {
      QLog.i("KSongView", 2, "over the sentence...");
      return 1.0F;
    }
    Character localCharacter = null;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < ((Sentence)localObject).jdField_b_of_type_JavaUtilArrayList.size())
      {
        localCharacter = (Character)((Sentence)localObject).jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        if (paramLong >= localCharacter.jdField_a_of_type_Long + localCharacter.jdField_b_of_type_Long) {}
      }
      else
      {
        if (localCharacter != null) {
          break;
        }
        QLog.i("KSongView", 2, "error, charaxter is null...");
        return 0.0F;
      }
      paramInt += 1;
    }
    localObject = (Character)((Sentence)localObject).jdField_b_of_type_JavaUtilArrayList.get(((Sentence)localObject).jdField_b_of_type_JavaUtilArrayList.size() - 1);
    float f = (float)(paramLong - localCharacter.jdField_a_of_type_Long) / (float)localCharacter.jdField_b_of_type_Long;
    return (localCharacter.jdField_a_of_type_Int + f) / ((Character)localObject).jdField_b_of_type_Int;
  }
  
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    this.daoTxt = new KSongTextView(paramContext);
    this.daoTxt.setText("● ● ● ● ●");
    this.daoTxt.setTextSize(2, 15.0F);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    this.daoTxt.setVisibility(4);
    localLinearLayout.addView(this.daoTxt, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ListView(paramContext);
    this.lvListView = ((ListView)localObject2);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.lvListView.setDivider(null);
    this.lvListView.setVerticalScrollBarEnabled(false);
    addView(localLinearLayout, paramAttributeSet);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundResource(2130843690);
    ((LinearLayout)localObject1).setClickable(true);
    addView((View)localObject1, paramAttributeSet);
    paramAttributeSet = this.lvListView;
    localObject1 = new ArrayList();
    this.list = ((List)localObject1);
    paramContext = new QwAdapter(paramContext, (List)localObject1, 2131560650, new KSongView.LrcHolder(this));
    this.lvAdapter = paramContext;
    paramAttributeSet.setAdapter(paramContext);
  }
  
  private KSHelper.Config parseConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("KSongView", 2, "error! config path wrong...");
    }
    KSHelper.Config localConfig;
    do
    {
      return null;
      try
      {
        paramString = QWalletTools.b(paramString);
        QLog.i("KSongView", 2, "config_content = " + paramString);
        if (TextUtils.isEmpty(paramString))
        {
          QLog.i("KSongView", 2, "error! config content wrong...");
          return null;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new JSONObject(paramString);
      localConfig = new KSHelper.Config();
      localConfig.singer = paramString.optString("name");
      localConfig.singer = paramString.optString("singer");
      localConfig.time = paramString.optLong("time");
      localConfig.ksongId = paramString.optString("ksongId");
      paramString = paramString.optJSONObject("qrcConfig");
    } while (paramString == null);
    localConfig.start = paramString.optLong("start", 0L);
    localConfig.end = paramString.optLong("end", 0L);
    localConfig.pretime = paramString.optLong("pretime", 0L);
    localConfig.total = paramString.optLong("total", 0L);
    if ((0L < localConfig.start) && (0L < localConfig.end) && (0L < localConfig.pretime) && (0L < localConfig.total))
    {
      paramString = localConfig;
      if (localConfig.start < localConfig.end) {}
    }
    else
    {
      QLog.i("KSongView", 2, "error! config is wrong...");
      paramString = null;
    }
    return paramString;
  }
  
  private boolean parseQrc(String paramString)
  {
    int k = 0;
    Object localObject = QWalletTools.b(paramString);
    paramString = LyricParseHelper.a((String)localObject, true);
    if ((paramString == null) || (paramString.a == null))
    {
      QLog.i("KSongView", 2, "error, parse Qrc fail, qrc = " + (String)localObject);
      return false;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramString.a.size())
      {
        localObject = (Sentence)paramString.a.get(i);
        if ((((Sentence)localObject).jdField_a_of_type_Long >= this.mConfig.start) && (((Sentence)localObject).jdField_a_of_type_Long + ((Sentence)localObject).jdField_b_of_type_Long <= this.mConfig.end)) {
          this.list.add(localObject);
        }
        if (((Sentence)localObject).jdField_a_of_type_Long >= this.mConfig.end) {
          j = k;
        }
      }
      else
      {
        while (j < 5)
        {
          this.list.add(new Sentence());
          j += 1;
        }
      }
      i += 1;
    }
    QLog.i("KSongView", 2, "list size = " + this.list.size());
    return true;
  }
  
  private boolean updateQrcSentence(long paramLong)
  {
    if (this.mState != 1) {
      return false;
    }
    if (this.indexLine >= this.list.size())
    {
      QLog.i("KSongView", 2, "error, out of scrop...");
      return false;
    }
    paramLong = this.mConfig.start + paramLong - this.mConfig.pretime;
    if (this.mkl != null) {
      this.mkl.update(paramLong);
    }
    Object localObject = (Sentence)this.list.get(this.indexLine);
    long l = ((Sentence)localObject).jdField_a_of_type_Long + ((Sentence)localObject).jdField_b_of_type_Long;
    updateSentence(paramLong);
    if (paramLong > l)
    {
      if (l >= this.mConfig.end)
      {
        QLog.i("KSongView", 2, "play over, no scroll...");
        return false;
      }
      QLog.i("KSongView", 2, "scroll to next line = " + this.indexLine + " duration = " + paramLong);
      localObject = this.lvListView;
      int i = this.indexLine + 1;
      this.indexLine = i;
      ((ListView)localObject).smoothScrollToPositionFromTop(i, -1, 50);
    }
    return true;
  }
  
  private void updateSentence(long paramLong)
  {
    View localView = this.lvListView.getChildAt(0);
    if (localView == null) {
      QLog.i("KSongView", 2, "update sentence v is null...");
    }
    do
    {
      return;
      this.ktv = ((KSongTextView)localView.findViewById(2131375158));
      QLog.i("KSongView", 2, "index line = " + this.indexLine);
    } while (this.ktv == null);
    float f = getSentenceRate(this.indexLine, paramLong);
    QLog.i("KSongView", 2, "show text color rate = " + f);
    this.ktv.updateRate(f, 15, -1);
  }
  
  public KSHelper.Config getConfig()
  {
    return this.mConfig;
  }
  
  public int getState()
  {
    try
    {
      int i = this.mState;
      return i;
    }
    finally {}
  }
  
  public void initLrc(String paramString1, String paramString2, KSongProsBar paramKSongProsBar, KSHelper.KListener paramKListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.i("KSongView", 2, "error! need thinds is null...");
      return;
    }
    this.prosBar = paramKSongProsBar;
    setKListener(paramKListener);
    this.mHandler = new KSongView.KHandler(this);
    new KSongView.InitTask(this).execute(new String[] { paramString1, paramString2 });
  }
  
  public void pause()
  {
    if (this.mState == 1)
    {
      this.mState = 2;
      this.mHandler.removeMessages(0);
      this.pauseStart = System.currentTimeMillis();
    }
  }
  
  public void play(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      if (this.mState < 0) {
        throw new RuntimeException("error! lyric object not initialized...");
      }
    }
    finally {}
    if (this.mState == 1)
    {
      QLog.i("KSongView", 2, "error, the playing is going...");
      return;
    }
    if (this.mState == 2)
    {
      this.mState = 1;
      this.mHandler.sendEmptyMessage(0);
      this.pauseTime += System.currentTimeMillis() - this.pauseStart;
      return;
    }
    QLog.i("KSongView", 2, "start playing...");
    if (this.mState == 3) {
      reset();
    }
    this.mState = 1;
    this.pauseTime = 0L;
    KSongTextView localKSongTextView = this.daoTxt;
    if (paramBoolean) {}
    for (;;)
    {
      localKSongTextView.initKSongGradient(i, 0);
      this.daoTxt.startDownTime(this.mConfig.pretime, null);
      this.startTime = System.currentTimeMillis();
      this.mHandler.sendEmptyMessage(0);
      return;
      i = getResources().getColor(2131166150);
    }
  }
  
  public void release()
  {
    if (this.mHandler != null) {
      this.mHandler.removeMessages(0);
    }
    if (this.mState > 0) {
      this.mState = 0;
    }
  }
  
  public void reset()
  {
    QLog.i("KSongView", 2, "start reset...");
    this.lvAdapter.notifyDataSetChanged();
    ListView localListView = this.lvListView;
    this.indexLine = 0;
    localListView.setSelection(0);
    if (this.prosBar != null) {
      this.prosBar.update(0L);
    }
    this.mHandler.removeMessages(0);
    if (this.mState > 0) {
      this.mState = 0;
    }
  }
  
  public void setKListener(KSHelper.KListener paramKListener)
  {
    this.mkl = paramKListener;
  }
  
  public void updateProsBar(long paramLong)
  {
    if (this.prosBar != null) {
      this.prosBar.update(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ksong.KSongView
 * JD-Core Version:    0.7.0.1
 */