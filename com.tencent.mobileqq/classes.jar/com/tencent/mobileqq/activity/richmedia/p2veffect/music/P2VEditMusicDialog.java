package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import actj;
import ahxg;
import ahxh;
import ahxi;
import ahxj;
import ajya;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import bbdh;
import bbdx;
import bbfj;
import bcql;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import stk;
import stx;
import syo;
import syq;
import tbr;
import tbu;
import tbz;
import tca;
import tcz;
import tmo;
import toi;
import vei;
import vej;
import vqx;
import vrh;
import vri;
import vrj;
import vrk;
import vyf;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, stk, syq<tmo, toi>, vri
{
  private static final String jdField_a_of_type_JavaLangString = P2VEditMusicDialog.class.getSimpleName();
  public int a;
  protected long a;
  public ahxj a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public MusicHorizontalSeekView a;
  protected P2VEditMusicDialog.MusicPlayTask a;
  public ArrayList<vrk> a;
  protected HashMap<String, String> a;
  protected Timer a;
  protected stx a;
  private tbz<tbu> jdField_a_of_type_Tbz = new ahxi(this);
  private vqx jdField_a_of_type_Vqx;
  public vrh a;
  public vrk a;
  public boolean a;
  public int b;
  protected long b;
  public View b;
  public TextView b;
  protected HashMap<String, Long> b;
  protected int c;
  protected View c;
  protected TextView c;
  protected volatile int d;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  
  public P2VEditMusicDialog(Context paramContext, ahxj paramahxj, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131755160);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new ahxh(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Ahxj = paramahxj;
    this.jdField_a_of_type_Vqx = new vqx(paramContext, new ahxg(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131755178;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { bbdh.a(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771979, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ahxj.a(this.jdField_a_of_type_Vrk);
    if (this.jdField_a_of_type_Vrk != null)
    {
      if (this.jdField_a_of_type_Vrk.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Vrk.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Vrk.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_Ahxj.a(vrk.jdField_b_of_type_Vrk);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_Ahxj.a(vrk.jdField_b_of_type_Vrk);
  }
  
  private void h()
  {
    vrk localvrk = this.jdField_a_of_type_Ahxj.a();
    if ((localvrk == null) || (this.jdField_a_of_type_Vrk == null) || ((localvrk.jdField_b_of_type_Int != 3) && (localvrk.jdField_b_of_type_Int != 2))) {}
    for (;;)
    {
      dismiss();
      return;
      if (localvrk.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Vrk.jdField_a_of_type_JavaLangString)) {}
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Ahxj.d();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int < 5000) {
      return 5000;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    f();
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561305, null);
    super.setContentView((View)localObject);
    boolean bool;
    if (this.jdField_a_of_type_Int < 5000)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131370557));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131370546);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131370548));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131370549));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375780));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131375779));
      this.e = ((TextView)super.findViewById(2131370553));
      this.f = ((TextView)super.findViewById(2131370554));
      this.e.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365641));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131375814);
      if (!this.jdField_a_of_type_Ahxj.b()) {
        break label459;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131370547));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365252);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidWidgetGridView;
      if (this.jdField_a_of_type_Ahxj.c()) {
        break label454;
      }
      bool = true;
      label317:
      this.jdField_a_of_type_Vrh = new vrh(paramContext, (GridView)localObject, bool, true);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Vrh);
      this.jdField_a_of_type_Vrh.a(null);
      label351:
      if (this.jdField_a_of_type_Ahxj.a() == null) {
        break label497;
      }
      this.jdField_a_of_type_Vrk = new vrk();
      this.jdField_a_of_type_Vrk.a(this.jdField_a_of_type_Ahxj.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = vrk.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (!bbfj.d(getContext())) {
        break label513;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new tmo();
      syo.a().a(paramContext, this);
      return;
      this.jdField_a_of_type_Long = 1000L;
      break;
      label454:
      bool = false;
      break label317;
      label459:
      ((View)localObject).findViewById(2131365165).getLayoutParams().height = actj.a(138.0F, paramContext.getResources());
      ((View)localObject).findViewById(2131370550).setVisibility(8);
      break label351;
      label497:
      this.jdField_a_of_type_Vrk = this.jdField_a_of_type_Ahxj.a();
    }
    label513:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    bcql.a(getContext(), ajya.a(2131707869), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = vrj.a(paramString);
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownloadFinish() url = " + paramString);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, str);
      vrk localvrk = this.jdField_a_of_type_Ahxj.a();
      if ((localvrk != null) && (paramString.equals(localvrk.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Ahxj.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(localvrk.jdField_a_of_type_JavaLangString, str).apply();
      }
      vei.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
        paramString = new StringBuffer("onDownloadFinish errCode = ").append(paramInt).append(", name = ").append(vyf.b(paramString)).append(", downloadTime = ").append(System.currentTimeMillis() - l).append(", fileSize = ").append(vyf.a(str)).append(", url = " + paramString);
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
      }
      return;
      vei.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      vej.a("0X80076D9");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.jdField_d_of_type_Int * 0.05F)
    {
      this.jdField_d_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onProgress() mIndex = " + this.jdField_d_of_type_Int + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.jdField_d_of_type_Int = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  public void a(tmo paramtmo, toi paramtoi, ErrorMessage paramErrorMessage)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label203;
      }
    }
    label203:
    for (paramtmo = "null";; paramtmo = paramErrorMessage.getErrorMessage())
    {
      QLog.d(str, 2, paramtmo);
      vei.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramtmo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramtmo.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramtmo);
      vei.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramtoi = paramtoi.a;
    int j = paramtoi.music_config.size();
    paramtmo = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramtmo.add(new vrk((qqstory_struct.MusicConfigInfo)paramtoi.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramtoi = new StringBuffer();
        paramtoi.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (vrk)paramtmo.get(i);
          paramtoi.append(", " + i + ": title = " + paramErrorMessage.jdField_b_of_type_JavaLangString + ", audioUrl = " + paramErrorMessage.jdField_d_of_type_JavaLangString);
          i += 1;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramtoi.toString());
      }
    }
    for (;;)
    {
      vei.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_JavaUtilArrayList = paramtmo;
      vrk.a(getContext(), paramtmo);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(vrk paramvrk)
  {
    String str2 = paramvrk.jdField_d_of_type_JavaLangString;
    String str1 = paramvrk.g;
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      paramvrk = str1;
      if (!vyf.e(str1))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
        paramvrk = str1;
        if (!vyf.e(str1)) {
          paramvrk = vrj.a(str2);
        }
      }
      if (vyf.e(paramvrk))
      {
        if ((this.jdField_a_of_type_Stx != null) && (this.jdField_a_of_type_Stx.a()))
        {
          bbdx.d(this.jdField_a_of_type_Stx.a());
          this.jdField_a_of_type_Stx.a();
        }
        if (this.jdField_a_of_type_Ahxj.a() != null)
        {
          this.jdField_a_of_type_Ahxj.a(paramvrk);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "exists audio_url = " + str2 + ", path = " + paramvrk);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getCurFragmentMusic - urMusic is null");
        }
      }
      if (!bbfj.g(BaseApplication.getContext()))
      {
        f();
        bcql.a(BaseApplication.getContext(), 2131695569, 0).a();
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramvrk);
      if ((this.jdField_a_of_type_Stx != null) && (this.jdField_a_of_type_Stx.a()))
      {
        bbdx.d(this.jdField_a_of_type_Stx.a());
        this.jdField_a_of_type_Stx.a();
      }
      ThreadManager.post(new P2VEditMusicDialog.3(this, str2), 5, null, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_Ahxj.b();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 1000;
    int j = (paramInt2 - paramInt1) / 1000 * 1000;
    if (j < 1000) {}
    for (;;)
    {
      j = i;
      if (this.jdField_c_of_type_Int == 1)
      {
        j = i;
        if (i > 8500.0D)
        {
          j = i;
          if (i < 13500.0D) {
            j = 10000;
          }
        }
      }
      i = j + paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(vrj.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(vrj.a(i, true));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    vrk localvrk = this.jdField_a_of_type_Ahxj.a();
    if (localvrk != null)
    {
      localvrk.jdField_d_of_type_Int = ((int)(localvrk.f * (paramInt3 / paramInt1)));
      localvrk.e = (localvrk.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      b(localvrk.jdField_d_of_type_Int, localvrk.e);
    }
  }
  
  public void b(vrk paramvrk)
  {
    if ((!TextUtils.isEmpty(paramvrk.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramvrk.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramvrk.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Ahxj.a(paramvrk);
    a(paramvrk);
    vej.a("0X80076D6");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ahxj.c();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    c();
  }
  
  public void d()
  {
    e();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = new P2VEditMusicDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_Vqx.a();
    if ((this.jdField_a_of_type_Stx != null) && (this.jdField_a_of_type_Stx.a()))
    {
      bbdx.d(this.jdField_a_of_type_Stx.a());
      this.jdField_a_of_type_Stx.a();
    }
    ((tbr)((tca)tcz.a(20)).a(1)).b(this.jdField_a_of_type_Tbz);
    e();
    c();
    super.dismiss();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  protected void f()
  {
    vrk localvrk = this.jdField_a_of_type_Ahxj.a();
    if ((localvrk != null) && (localvrk.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Vrh != null) && (this.jdField_a_of_type_Vrh.a(localvrk) > 0) && (!localvrk.equals(this.jdField_a_of_type_Vrh.a())))
    {
      this.jdField_a_of_type_Vrh.a(localvrk);
      this.jdField_a_of_type_Vrh.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void onBackPressed()
  {
    g();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370553: 
      g();
      dismiss();
      return;
    case 2131370554: 
      h();
      return;
    }
    h();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Vrh != null)
    {
      paramAdapterView = (vrk)this.jdField_a_of_type_Vrh.getItem(paramInt);
      if (paramAdapterView != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onItemClick error musicInfo = " + null);
      }
    }
    label57:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Vrh.a(paramAdapterView);
        this.jdField_a_of_type_Vrh.notifyDataSetChanged();
        if (paramInt >= this.jdField_a_of_type_Vrh.a()) {
          break;
        }
        b();
        if (paramAdapterView.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Ahxj.a(paramAdapterView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          return;
        }
        if (paramAdapterView.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_Ahxj.a(paramAdapterView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          return;
        }
      } while (paramAdapterView.jdField_b_of_type_Int != 2);
      if (!bbfj.g(BaseApplication.getContext()))
      {
        f();
        bcql.a(BaseApplication.getContext(), 2131695569, 0).a();
        return;
      }
      this.jdField_a_of_type_Ahxj.a();
    } while ((this.jdField_a_of_type_Ahxj.a()) || (!(getContext() instanceof ContextThemeWrapper)) || (!(((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity)));
    a((Activity)((ContextThemeWrapper)getContext()).getBaseContext());
    return;
    b();
    if (!TextUtils.isEmpty(paramAdapterView.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdapterView.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Ahxj.a(paramAdapterView);
    a(paramAdapterView);
    vei.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */