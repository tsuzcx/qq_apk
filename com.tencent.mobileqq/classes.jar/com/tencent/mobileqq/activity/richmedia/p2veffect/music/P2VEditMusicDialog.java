package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import alsy;
import alsz;
import alta;
import altb;
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
import anvx;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import wam;
import waz;
import wfi;
import wfk;
import wik;
import win;
import wis;
import wit;
import wjs;
import wth;
import wvb;
import ykv;
import ykw;
import ywx;
import yxh;
import yxi;
import yxj;
import yxk;
import zeb;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, wam, wfk<wth, wvb>, yxi
{
  private static final String jdField_a_of_type_JavaLangString = P2VEditMusicDialog.class.getSimpleName();
  public int a;
  protected long a;
  public altb a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public MusicHorizontalSeekView a;
  protected P2VEditMusicDialog.MusicPlayTask a;
  public ArrayList<yxk> a;
  protected HashMap<String, String> a;
  protected Timer a;
  protected waz a;
  private wis<win> jdField_a_of_type_Wis = new alta(this);
  private ywx jdField_a_of_type_Ywx;
  public yxh a;
  public yxk a;
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
  
  public P2VEditMusicDialog(Context paramContext, altb paramaltb, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131755166);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new alsz(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Altb = paramaltb;
    this.jdField_a_of_type_Ywx = new ywx(paramContext, new alsy(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131755184;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.getIMEI(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771979, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Altb.a(this.jdField_a_of_type_Yxk);
    if (this.jdField_a_of_type_Yxk != null)
    {
      if (this.jdField_a_of_type_Yxk.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Yxk.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Yxk.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_Altb.a(yxk.jdField_b_of_type_Yxk);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_Altb.a(yxk.jdField_b_of_type_Yxk);
  }
  
  private void h()
  {
    yxk localyxk = this.jdField_a_of_type_Altb.a();
    if ((localyxk == null) || (this.jdField_a_of_type_Yxk == null) || ((localyxk.jdField_b_of_type_Int != 3) && (localyxk.jdField_b_of_type_Int != 2))) {}
    for (;;)
    {
      dismiss();
      return;
      if (localyxk.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Yxk.jdField_a_of_type_JavaLangString)) {}
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Altb.d();
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
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561735, null);
    super.setContentView((View)localObject);
    boolean bool;
    if (this.jdField_a_of_type_Int < 5000)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131371708));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131371692);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131371694));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371695));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377271));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377270));
      this.e = ((TextView)super.findViewById(2131371704));
      this.f = ((TextView)super.findViewById(2131371705));
      this.e.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131366145));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131377321);
      if (!this.jdField_a_of_type_Altb.b()) {
        break label459;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131371693));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365742);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidWidgetGridView;
      if (this.jdField_a_of_type_Altb.c()) {
        break label454;
      }
      bool = true;
      label317:
      this.jdField_a_of_type_Yxh = new yxh(paramContext, (GridView)localObject, bool, true);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Yxh);
      this.jdField_a_of_type_Yxh.a(null);
      label351:
      if (this.jdField_a_of_type_Altb.a() == null) {
        break label497;
      }
      this.jdField_a_of_type_Yxk = new yxk();
      this.jdField_a_of_type_Yxk.a(this.jdField_a_of_type_Altb.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = yxk.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (!NetworkUtil.isNetSupport(getContext())) {
        break label513;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new wth();
      wfi.a().a(paramContext, this);
      return;
      this.jdField_a_of_type_Long = 1000L;
      break;
      label454:
      bool = false;
      break label317;
      label459:
      ((View)localObject).findViewById(2131365661).getLayoutParams().height = AIOUtils.dp2px(138.0F, paramContext.getResources());
      ((View)localObject).findViewById(2131371696).setVisibility(8);
      break label351;
      label497:
      this.jdField_a_of_type_Yxk = this.jdField_a_of_type_Altb.a();
    }
    label513:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), anvx.a(2131707318), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = yxj.a(paramString);
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
      yxk localyxk = this.jdField_a_of_type_Altb.a();
      if ((localyxk != null) && (paramString.equals(localyxk.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Altb.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(localyxk.jdField_a_of_type_JavaLangString, str).apply();
      }
      ykv.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
        paramString = new StringBuffer("onDownloadFinish errCode = ").append(paramInt).append(", name = ").append(zeb.b(paramString)).append(", downloadTime = ").append(System.currentTimeMillis() - l).append(", fileSize = ").append(zeb.a(str)).append(", url = " + paramString);
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
      }
      return;
      ykv.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      ykw.a("0X80076D9");
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
  
  public void a(wth paramwth, wvb paramwvb, ErrorMessage paramErrorMessage)
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
    for (paramwth = "null";; paramwth = paramErrorMessage.getErrorMessage())
    {
      QLog.d(str, 2, paramwth);
      ykv.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramwth = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramwth.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramwth);
      ykv.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramwvb = paramwvb.a;
    int j = paramwvb.music_config.size();
    paramwth = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramwth.add(new yxk((qqstory_struct.MusicConfigInfo)paramwvb.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramwvb = new StringBuffer();
        paramwvb.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (yxk)paramwth.get(i);
          paramwvb.append(", " + i + ": title = " + paramErrorMessage.jdField_b_of_type_JavaLangString + ", audioUrl = " + paramErrorMessage.jdField_d_of_type_JavaLangString);
          i += 1;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramwvb.toString());
      }
    }
    for (;;)
    {
      ykv.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_JavaUtilArrayList = paramwth;
      yxk.a(getContext(), paramwth);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(yxk paramyxk)
  {
    String str2 = paramyxk.jdField_d_of_type_JavaLangString;
    String str1 = paramyxk.g;
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      paramyxk = str1;
      if (!zeb.e(str1))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
        paramyxk = str1;
        if (!zeb.e(str1)) {
          paramyxk = yxj.a(str2);
        }
      }
      if (zeb.e(paramyxk))
      {
        if ((this.jdField_a_of_type_Waz != null) && (this.jdField_a_of_type_Waz.a()))
        {
          FileUtils.deleteFile(this.jdField_a_of_type_Waz.a());
          this.jdField_a_of_type_Waz.a();
        }
        if (this.jdField_a_of_type_Altb.a() != null)
        {
          this.jdField_a_of_type_Altb.a(paramyxk);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "exists audio_url = " + str2 + ", path = " + paramyxk);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getCurFragmentMusic - urMusic is null");
        }
      }
      if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
      {
        f();
        QQToast.a(BaseApplication.getContext(), 2131694983, 0).a();
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramyxk);
      if ((this.jdField_a_of_type_Waz != null) && (this.jdField_a_of_type_Waz.a()))
      {
        FileUtils.deleteFile(this.jdField_a_of_type_Waz.a());
        this.jdField_a_of_type_Waz.a();
      }
      ThreadManager.post(new P2VEditMusicDialog.3(this, str2), 5, null, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_Altb.b();
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(yxj.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(yxj.a(i, true));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    yxk localyxk = this.jdField_a_of_type_Altb.a();
    if (localyxk != null)
    {
      localyxk.jdField_d_of_type_Int = ((int)(localyxk.f * (paramInt3 / paramInt1)));
      localyxk.e = (localyxk.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      b(localyxk.jdField_d_of_type_Int, localyxk.e);
    }
  }
  
  public void b(yxk paramyxk)
  {
    if ((!TextUtils.isEmpty(paramyxk.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramyxk.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramyxk.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Altb.a(paramyxk);
    a(paramyxk);
    ykw.a("0X80076D6");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Altb.c();
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
    this.jdField_a_of_type_Ywx.a();
    if ((this.jdField_a_of_type_Waz != null) && (this.jdField_a_of_type_Waz.a()))
    {
      FileUtils.deleteFile(this.jdField_a_of_type_Waz.a());
      this.jdField_a_of_type_Waz.a();
    }
    ((wik)((wit)wjs.a(20)).a(1)).b(this.jdField_a_of_type_Wis);
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
    yxk localyxk = this.jdField_a_of_type_Altb.a();
    if ((localyxk != null) && (localyxk.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Yxh != null) && (this.jdField_a_of_type_Yxh.a(localyxk) > 0) && (!localyxk.equals(this.jdField_a_of_type_Yxh.a())))
    {
      this.jdField_a_of_type_Yxh.a(localyxk);
      this.jdField_a_of_type_Yxh.notifyDataSetChanged();
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      g();
      dismiss();
      continue;
      h();
      continue;
      h();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    yxk localyxk;
    if (this.jdField_a_of_type_Yxh != null)
    {
      localyxk = (yxk)this.jdField_a_of_type_Yxh.getItem(paramInt);
      if (localyxk != null) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onItemClick error musicInfo = " + null);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label70:
      this.jdField_a_of_type_Yxh.a(localyxk);
      this.jdField_a_of_type_Yxh.notifyDataSetChanged();
      if (paramInt < this.jdField_a_of_type_Yxh.a())
      {
        b();
        if (localyxk.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Altb.a(localyxk);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        else if (localyxk.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_Altb.a(localyxk);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        }
        else if (localyxk.jdField_b_of_type_Int == 2)
        {
          if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
          {
            f();
            QQToast.a(BaseApplication.getContext(), 2131694983, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Altb.a();
            if ((!this.jdField_a_of_type_Altb.a()) && ((getContext() instanceof ContextThemeWrapper)) && ((((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity))) {
              a((Activity)((ContextThemeWrapper)getContext()).getBaseContext());
            }
          }
        }
      }
      else
      {
        b();
        if (!TextUtils.isEmpty(localyxk.jdField_d_of_type_JavaLangString))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(localyxk.jdField_b_of_type_JavaLangString);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Altb.a(localyxk);
        a(localyxk);
        ykv.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */