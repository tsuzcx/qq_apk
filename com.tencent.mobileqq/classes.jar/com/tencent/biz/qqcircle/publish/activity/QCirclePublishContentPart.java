package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostTextBuilder;
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils.QCircleResultData;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.event.QCirclePublishKeyboardEvent;
import com.tencent.biz.qqcircle.publish.model.Friend;
import com.tencent.biz.qqcircle.publish.view.ExtendScrollView;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.qqcircle.publish.model.Friend;>;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QCirclePublishContentPart
  extends QCircleBasePart
  implements View.OnClickListener, SimpleEventReceiver
{
  public static Pattern p = Pattern.compile("#[，a-z0-9A-Z一-龥]+");
  protected InputMethodManager a;
  public boolean c = true;
  protected int d;
  protected SoftKeyboardStateHelper e;
  public ExtendEditText f;
  protected ImageView g;
  protected ImageView h;
  protected ImageView i;
  protected boolean j = false;
  protected boolean k = false;
  public String l;
  public List<Friend> m;
  public int n = 0;
  protected boolean o = false;
  private QCirclePublishViewModel q;
  private View r;
  private int s;
  private View t;
  private int u = -1;
  private int v = -1;
  private String w = "";
  private boolean x = false;
  private String y;
  private long z = 0L;
  
  public static int a(EditText paramEditText, ArrayList<HostSelectMemberUtils.QCircleResultData> paramArrayList, List<Friend> paramList, int paramInt)
  {
    if (paramArrayList == null) {
      return paramInt;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject2 = (HostSelectMemberUtils.QCircleResultData)paramArrayList.next();
      Object localObject1 = new Friend();
      if (!TextUtils.isEmpty(((HostSelectMemberUtils.QCircleResultData)localObject2).name)) {
        ((Friend)localObject1).b = ((HostSelectMemberUtils.QCircleResultData)localObject2).name;
      } else {
        ((Friend)localObject1).b = ((HostSelectMemberUtils.QCircleResultData)localObject2).uin;
      }
      try
      {
        long l1 = Long.valueOf(((HostSelectMemberUtils.QCircleResultData)localObject2).uin).longValue();
        ((Friend)localObject1).a = l1;
        if ((((Friend)localObject1).b != null) && (((Friend)localObject1).a != 0L))
        {
          if (paramList == null) {
            return paramInt;
          }
          paramList.add(localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("@");
          ((StringBuilder)localObject2).append(((Friend)localObject1).b);
          ((StringBuilder)localObject2).append(" ");
          localObject1 = ((StringBuilder)localObject2).toString();
          int i1 = paramInt;
          if (paramInt < ((String)localObject1).length()) {
            i1 = ((String)localObject1).length();
          }
          a((String)localObject1, paramEditText.getSelectionStart(), paramEditText);
          paramInt = i1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label205:
        break label205;
      }
    }
    return paramInt;
  }
  
  private int a(CharSequence paramCharSequence, int paramInt)
  {
    return a(paramCharSequence, paramInt, this.n, this.m, this.u, this.v, this.w);
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return "";
    }
    paramEditText = paramEditText.getText();
    if ((paramEditText instanceof QQTextBuilder)) {
      return ((QQTextBuilder)paramEditText).toPlainText();
    }
    return paramEditText.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str = Pattern.compile(paramString1, 16).matcher(paramString2).replaceFirst(paramString3);
      return str;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return b(paramString2, paramString1, paramString3);
  }
  
  public static void a(String paramString, int paramInt, EditText paramEditText)
  {
    if ((paramEditText != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt < 0) {
        return;
      }
      QCircleHostTextBuilder.getEmoctationFacory().newEditable(paramEditText.getText()).insert(paramInt, paramString);
      paramEditText.setSelection(paramInt + paramString.length());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    return (paramInt1 != -1) && (paramInt2 != -1) && (paramString != null) && (paramString.length() > 0);
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.m, this.u, this.v, this.w);
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfChar.length);
    paramString = QCircleHostTextBuilder.createQzoneTextBuilder(paramString);
    int i2 = arrayOfChar.length;
    int i1 = 0;
    EmoticonSpan[] arrayOfEmoticonSpan = (EmoticonSpan[])paramString.getSpans(0, i2, EmoticonSpan.class);
    Arrays.sort(arrayOfEmoticonSpan, new QCirclePublishContentPart.9(paramString));
    int i4 = arrayOfEmoticonSpan.length;
    int i3;
    for (i2 = 0; i1 < i4; i2 = i3)
    {
      EmoticonSpan localEmoticonSpan = arrayOfEmoticonSpan[i1];
      int i5 = paramString.getSpanStart(localEmoticonSpan);
      i3 = paramString.getSpanEnd(localEmoticonSpan);
      if ((localEmoticonSpan == null) || (i5 >= i3) || (i3 <= 0)) {
        break;
      }
      if (i5 > i2) {
        localStringBuilder.append(arrayOfChar, i2, i5 - i2);
      }
      i2 = localEmoticonSpan.emojiType;
      if (i2 != 0)
      {
        if (i2 != 1)
        {
          if (i2 == 2) {
            localStringBuilder.append(localEmoticonSpan.getDescription());
          }
        }
        else {
          localStringBuilder.append(com.tencent.mobileqq.text.EmotcationConstants.SYS_EMOTICON_SYMBOL[(localEmoticonSpan.index & 0x7FFFFFFF)]);
        }
      }
      else
      {
        i2 = HostEmotionUtil.getEmojiUnicode(localEmoticonSpan.index);
        if (i2 != -1) {
          localStringBuilder.append(String.valueOf(Character.toChars(i2)));
        } else {
          QLog.e("QzoneTextBuilder", 1, "不支持的表情");
        }
      }
      i1 += 1;
    }
    if (i2 < arrayOfChar.length) {
      localStringBuilder.append(arrayOfChar, i2, arrayOfChar.length - i2);
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    int i1 = paramString1.indexOf(paramString2, 0);
    if (i1 == -1) {
      return paramString1;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.replace(i1, paramString2.length() + i1, paramString3);
    return paramString1.toString();
  }
  
  public static String c(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.nextToken());
      localStringBuilder.append(' ');
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString().trim();
  }
  
  private void d(View paramView)
  {
    ExtendScrollView localExtendScrollView = (ExtendScrollView)paramView.findViewById(2131450247);
    this.f = ((ExtendEditText)paramView.findViewById(2131431344));
    localExtendScrollView.a(2131431344);
    this.f.setHint(QCircleConfigHelper.ae());
    this.f.setFixedHeight(true);
    this.f.setOnClickListener(this);
    this.f.setHintTextColor(QCircleSkinHelper.getInstance().getColor(2131167085));
    this.f.setEditableFactory(QCircleHostTextBuilder.getEmoctationFacory());
    s();
  }
  
  private void e(View paramView)
  {
    this.e = new SoftKeyboardStateHelper(paramView);
    this.e.a(new QCirclePublishContentPart.6(this));
  }
  
  private void x()
  {
    Object localObject = this.r;
    if ((localObject != null) && (((View)localObject).getLayoutParams() != null))
    {
      if (this.d > 0) {
        this.r.getLayoutParams().height = this.d;
      } else {
        this.r.getLayoutParams().height = ViewUtils.a(250.0F);
      }
      this.r.invalidate();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEmojiPanel onGetKeyBoardHeight() :");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("[QcirclePublish]QCirclePublishContentPart", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void y()
  {
    this.w = "";
    this.u = -1;
    this.v = -1;
  }
  
  private void z()
  {
    if (this.q == null) {
      this.q = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    this.q.d.observe(j(), new QCirclePublishContentPart.8(this));
  }
  
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, List<Friend> paramList, int paramInt3, int paramInt4, String paramString)
  {
    if (paramCharSequence != null)
    {
      int i2 = paramCharSequence.length();
      int i1 = 1;
      if (i2 <= 1) {
        return -1;
      }
      if (paramCharSequence.length() <= paramInt1) {
        paramInt1 = paramCharSequence.length();
      }
      i2 = paramInt1 - 1;
      while ((i2 >= 0) && (i1 <= paramInt2))
      {
        if ((paramCharSequence.charAt(i2) == '@') && (a(paramCharSequence.toString().substring(i2, paramInt1), false, paramList, paramInt3, paramInt4, paramString))) {
          return i2;
        }
        i2 -= 1;
        i1 += 1;
      }
    }
    return -1;
  }
  
  public long a(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public String a()
  {
    return "[QcirclePublish]QCirclePublishContentPart";
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    Matcher localMatcher = RichTextAtParser.a.matcher(paramString);
    int i1 = 0;
    try
    {
      while (localMatcher.find())
      {
        int i2 = localMatcher.start();
        int i3 = localMatcher.end();
        Object localObject1 = localMatcher.group();
        int i4 = ((String)localObject1).indexOf("uin:");
        int i5 = ((String)localObject1).indexOf(",nick:");
        String str1 = ((String)localObject1).substring(i4 + 4, i5);
        String str2 = ((String)localObject1).substring(i5 + 6, ((String)localObject1).length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@");
        ((StringBuilder)localObject2).append(str2);
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString.replace(i2 - i1, i3 - i1, (String)localObject2);
        i1 += ((String)localObject1).length() - ((String)localObject2).length();
        localObject1 = new Friend();
        ((Friend)localObject1).b = str2;
        try
        {
          ((Friend)localObject1).a = Long.valueOf(str1).longValue();
          if (this.m == null) {
            this.m = new ArrayList();
          }
          this.m.add(localObject1);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("[QcirclePublish]QCirclePublishContentPart", 1, localNumberFormatException, new Object[0]);
        }
      }
      return paramString.toString();
    }
    catch (Exception localException)
    {
      QLog.e("[QcirclePublish]QCirclePublishContentPart", 1, localException, new Object[0]);
    }
  }
  
  public String a(String paramString, List<Friend> paramList)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return paramString;
      }
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        localObject = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        Friend localFriend = (Friend)localIterator.next();
        localObject = localFriend.b;
        paramList = (List<Friend>)localObject;
        if (localObject == null)
        {
          paramList = new StringBuilder();
          paramList.append(localFriend.a);
          paramList.append("");
          paramList = paramList.toString();
        }
        paramList = paramList.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@{uin:");
        ((StringBuilder)localObject).append(localFriend.a);
        ((StringBuilder)localObject).append(",nick:");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append("}");
        paramList = ((StringBuilder)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(b(localFriend.b));
        localObject = ((StringBuilder)localObject).toString();
        if ((!TextUtils.isEmpty(localFriend.b)) && (paramString.contains((CharSequence)localObject))) {
          paramString = a((String)localObject, paramString, paramList);
        }
      }
    }
    return localObject;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1001) {
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    HostUIHelper.closeHostEnvironment();
    if ((paramInt == -1) && (paramIntent != null))
    {
      a(HostSelectMemberUtils.getResultList(paramIntent));
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onAtUserResult error, resultCode:");
    paramIntent.append(paramInt);
    QLog.e("[QcirclePublish]QCirclePublishContentPart", 1, paramIntent.toString());
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    d(paramView);
    i();
    b(paramView);
    z();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return;
    }
    Object localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(paramCharSequence);
    paramCharSequence = new SpannableStringBuilder((CharSequence)localObject1);
    int i1 = 0;
    localObject1 = p.matcher(paramCharSequence);
    while (((Matcher)localObject1).find())
    {
      i2 = ((Matcher)localObject1).start();
      int i3 = ((Matcher)localObject1).end();
      if (i3 - i2 != 1)
      {
        paramCharSequence.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(2131167083)), i2, i3, 33);
        i1 = 1;
      }
    }
    localObject1 = this.m;
    int i2 = i1;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        i2 = i1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = (Friend)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("@");
        localStringBuilder.append(((Friend)localObject2).b);
        localObject2 = Pattern.compile(localStringBuilder.toString()).matcher(paramCharSequence);
        while (((Matcher)localObject2).find())
        {
          i1 = ((Matcher)localObject2).start();
          i2 = ((Matcher)localObject2).end();
          paramCharSequence.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(2131167083)), i1, i2, 33);
          i1 = 1;
        }
      }
    }
    if (i2 != 0)
    {
      i1 = this.f.getSelectionStart();
      i2 = this.f.getSelectionEnd();
      this.f.setText(paramCharSequence);
      this.f.setSelection(i1, i2);
    }
  }
  
  public void a(ArrayList<HostSelectMemberUtils.QCircleResultData> paramArrayList)
  {
    if (this.f == null) {
      return;
    }
    if (this.m == null) {
      this.m = new ArrayList();
    }
    if (this.o)
    {
      int i1 = this.f.getSelectionStart();
      Editable localEditable = this.f.getEditableText();
      if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString())))
      {
        String str = localEditable.toString();
        int i2 = i1 - 1;
        if (str.substring(i2, i1).equals("@")) {
          localEditable.delete(i2, i1);
        }
      }
      this.o = false;
    }
    this.n = a(this.f, paramArrayList, this.m, this.n);
    q();
  }
  
  public boolean a(String paramString1, boolean paramBoolean, List<Friend> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (((a(paramInt1, paramInt2, paramString2)) || (!paramBoolean)) && (paramList != null))
    {
      paramInt2 = paramList.size();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString2 = (Friend)paramList.get(paramInt1);
        if ((paramString2 != null) && (paramString2.b != null) && (paramString1 != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("@");
          localStringBuilder.append(paramString2.b);
          if (!paramString1.equalsIgnoreCase(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("@");
            localStringBuilder.append(paramString2.b);
            localStringBuilder.append(" ");
            if (!paramString1.equalsIgnoreCase(localStringBuilder.toString())) {}
          }
          else
          {
            if (paramBoolean) {
              paramList.remove(paramInt1);
            }
            return true;
          }
        }
        paramInt1 += 1;
      }
    }
    return false;
  }
  
  protected final void b(View paramView)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    LinearLayout localLinearLayout = new LinearLayout(c());
    localLinearLayout.setOrientation(1);
    this.t = LayoutInflater.from(c()).inflate(2131626938, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.t.setVisibility(4);
    localLinearLayout.addView(this.t, localLayoutParams);
    if (this.r != null)
    {
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.addView(this.r, localLayoutParams);
      this.r.setVisibility(8);
    }
    localRelativeLayout.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new Rect();
    localRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject);
    this.s = ((Rect)localObject).height();
    localRelativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new QCirclePublishContentPart.2(this, localRelativeLayout));
    this.g = ((ImageView)paramView.findViewById(2131445972));
    this.h = ((ImageView)paramView.findViewById(2131445968));
    this.i = ((ImageView)paramView.findViewById(2131445969));
    l();
    e(paramView);
  }
  
  protected boolean b(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = this.a;
    if (localInputMethodManager != null)
    {
      ExtendEditText localExtendEditText = this.f;
      if (localExtendEditText == null) {
        return false;
      }
      if (localInputMethodManager.hideSoftInputFromWindow(localExtendEditText.getWindowToken(), 0))
      {
        if (paramBoolean) {
          this.f.clearFocus();
        }
        this.c = true;
        return true;
      }
      this.c = true;
    }
    return false;
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    b(paramBoolean);
    o();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishKeyboardEvent.class);
    return localArrayList;
  }
  
  protected void i()
  {
    QCirclePublishContentPart.1 local1 = new QCirclePublishContentPart.1(this);
    this.r = HostEmotionUtil.getEmojiPanel(HostUIHelper.getInstance().getHostApplicationContext(), local1);
  }
  
  protected void l()
  {
    ImageView localImageView = this.g;
    if (localImageView == null) {
      return;
    }
    localImageView.setOnClickListener(new QCirclePublishContentPart.3(this));
    this.i.setOnClickListener(this);
    m();
  }
  
  protected void m()
  {
    this.h.setOnClickListener(new QCirclePublishContentPart.4(this));
  }
  
  protected void n()
  {
    if (this.r == null) {
      return;
    }
    if (this.k) {
      return;
    }
    p();
    this.f.requestFocus();
    this.k = true;
    RFThreadManager.getUIHandler().postDelayed(new QCirclePublishContentPart.5(this), 100L);
  }
  
  protected boolean o()
  {
    View localView = this.r;
    if (localView == null) {
      return false;
    }
    if (this.j)
    {
      this.j = false;
      localView.setVisibility(8);
      this.g.setImageDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845359));
      return true;
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    this.a = ((InputMethodManager)c().getSystemService("input_method"));
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.m;
    if (paramActivity != null) {
      paramActivity.clear();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431344)
    {
      o();
    }
    else if (paramView.getId() == 2131445969)
    {
      r();
      this.t.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishKeyboardEvent))
    {
      if (((QCirclePublishKeyboardEvent)paramSimpleBaseEvent).showKeyboard)
      {
        q();
        return;
      }
      r();
    }
  }
  
  public boolean p()
  {
    return b(false);
  }
  
  public void q()
  {
    InputMethodManager localInputMethodManager = this.a;
    if (localInputMethodManager != null)
    {
      ExtendEditText localExtendEditText = this.f;
      if (localExtendEditText == null) {
        return;
      }
      localInputMethodManager.showSoftInput(localExtendEditText, 2);
      this.c = false;
    }
  }
  
  protected void r()
  {
    c(true);
  }
  
  protected void s()
  {
    ExtendEditText localExtendEditText = this.f;
    if (localExtendEditText == null) {
      return;
    }
    localExtendEditText.addTextChangedListener(new QCirclePublishContentPart.7(this));
  }
  
  protected boolean t()
  {
    return true;
  }
  
  protected void u()
  {
    long l1 = this.z;
    if ((l1 != 0L) && (a(l1) < 3000L)) {
      return;
    }
    this.z = System.currentTimeMillis();
    int i1 = v() - w();
    if (i1 > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("超出");
      localStringBuilder.append(i1);
      localStringBuilder.append("个字");
      QCircleToast.a(localStringBuilder.toString(), QCircleToast.c);
      this.x = true;
      return;
    }
    this.x = false;
  }
  
  public int v()
  {
    ExtendEditText localExtendEditText = this.f;
    if (localExtendEditText != null) {
      return c(a(localExtendEditText)).length();
    }
    return 0;
  }
  
  public int w()
  {
    return 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart
 * JD-Core Version:    0.7.0.1
 */