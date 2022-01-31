package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import aepi;
import ajtf;
import ajtg;
import ajth;
import ajti;
import alud;
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
import bdgk;
import bdhb;
import bdin;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import uml;
import umy;
import urp;
import urr;
import uus;
import uuv;
import uva;
import uvb;
import uwa;
import vfp;
import vhj;
import wxj;
import wxk;
import xjy;
import xki;
import xkj;
import xkk;
import xkl;
import xrg;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, uml, urr<vfp, vhj>, xkj
{
  private static final String jdField_a_of_type_JavaLangString = P2VEditMusicDialog.class.getSimpleName();
  public int a;
  protected long a;
  public ajti a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public MusicHorizontalSeekView a;
  protected P2VEditMusicDialog.MusicPlayTask a;
  public ArrayList<xkl> a;
  protected HashMap<String, String> a;
  protected Timer a;
  protected umy a;
  private uva<uuv> jdField_a_of_type_Uva = new ajth(this);
  private xjy jdField_a_of_type_Xjy;
  public xki a;
  public xkl a;
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
  
  public P2VEditMusicDialog(Context paramContext, ajti paramajti, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131755164);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new ajtg(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Ajti = paramajti;
    this.jdField_a_of_type_Xjy = new xjy(paramContext, new ajtf(this), this.jdField_a_of_type_AndroidOsHandler);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131755182;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { bdgk.a(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771979, 0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ajti.a(this.jdField_a_of_type_Xkl);
    if (this.jdField_a_of_type_Xkl != null)
    {
      if (this.jdField_a_of_type_Xkl.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_Xkl.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xkl.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_Ajti.a(xkl.jdField_b_of_type_Xkl);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_Ajti.a(xkl.jdField_b_of_type_Xkl);
  }
  
  private void h()
  {
    xkl localxkl = this.jdField_a_of_type_Ajti.a();
    if ((localxkl == null) || (this.jdField_a_of_type_Xkl == null) || ((localxkl.jdField_b_of_type_Int != 3) && (localxkl.jdField_b_of_type_Int != 2))) {}
    for (;;)
    {
      dismiss();
      return;
      if (localxkl.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Xkl.jdField_a_of_type_JavaLangString)) {}
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Ajti.d();
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
    Object localObject = LayoutInflater.from(paramContext).inflate(2131561513, null);
    super.setContentView((View)localObject);
    boolean bool;
    if (this.jdField_a_of_type_Int < 5000)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131370881));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131370870);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131370872));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131370873));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376329));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376328));
      this.e = ((TextView)super.findViewById(2131370877));
      this.f = ((TextView)super.findViewById(2131370878));
      this.e.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365727));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131376367);
      if (!this.jdField_a_of_type_Ajti.b()) {
        break label459;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131370871));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131365339);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      localObject = this.jdField_a_of_type_AndroidWidgetGridView;
      if (this.jdField_a_of_type_Ajti.c()) {
        break label454;
      }
      bool = true;
      label317:
      this.jdField_a_of_type_Xki = new xki(paramContext, (GridView)localObject, bool, true);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Xki);
      this.jdField_a_of_type_Xki.a(null);
      label351:
      if (this.jdField_a_of_type_Ajti.a() == null) {
        break label497;
      }
      this.jdField_a_of_type_Xkl = new xkl();
      this.jdField_a_of_type_Xkl.a(this.jdField_a_of_type_Ajti.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = xkl.a(getContext());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (!bdin.d(getContext())) {
        break label513;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new vfp();
      urp.a().a(paramContext, this);
      return;
      this.jdField_a_of_type_Long = 1000L;
      break;
      label454:
      bool = false;
      break label317;
      label459:
      ((View)localObject).findViewById(2131365252).getLayoutParams().height = aepi.a(138.0F, paramContext.getResources());
      ((View)localObject).findViewById(2131370874).setVisibility(8);
      break label351;
      label497:
      this.jdField_a_of_type_Xkl = this.jdField_a_of_type_Ajti.a();
    }
    label513:
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    QQToast.a(getContext(), alud.a(2131708253), 0).a();
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = xkk.a(paramString);
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
      xkl localxkl = this.jdField_a_of_type_Ajti.a();
      if ((localxkl != null) && (paramString.equals(localxkl.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Ajti.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(localxkl.jdField_a_of_type_JavaLangString, str).apply();
      }
      wxj.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
        paramString = new StringBuffer("onDownloadFinish errCode = ").append(paramInt).append(", name = ").append(xrg.b(paramString)).append(", downloadTime = ").append(System.currentTimeMillis() - l).append(", fileSize = ").append(xrg.a(str)).append(", url = " + paramString);
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.toString());
      }
      return;
      wxj.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      wxk.a("0X80076D9");
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
  
  public void a(vfp paramvfp, vhj paramvhj, ErrorMessage paramErrorMessage)
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
    for (paramvfp = "null";; paramvfp = paramErrorMessage.getErrorMessage())
    {
      QLog.d(str, 2, paramvfp);
      wxj.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramvfp = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramvfp.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramvfp);
      wxj.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramvhj = paramvhj.a;
    int j = paramvhj.music_config.size();
    paramvfp = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramvfp.add(new xkl((qqstory_struct.MusicConfigInfo)paramvhj.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramvhj = new StringBuffer();
        paramvhj.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (xkl)paramvfp.get(i);
          paramvhj.append(", " + i + ": title = " + paramErrorMessage.jdField_b_of_type_JavaLangString + ", audioUrl = " + paramErrorMessage.jdField_d_of_type_JavaLangString);
          i += 1;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramvhj.toString());
      }
    }
    for (;;)
    {
      wxj.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_JavaUtilArrayList = paramvfp;
      xkl.a(getContext(), paramvfp);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(xkl paramxkl)
  {
    String str2 = paramxkl.jdField_d_of_type_JavaLangString;
    String str1 = paramxkl.g;
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str1)))
    {
      paramxkl = str1;
      if (!xrg.e(str1))
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
        paramxkl = str1;
        if (!xrg.e(str1)) {
          paramxkl = xkk.a(str2);
        }
      }
      if (xrg.e(paramxkl))
      {
        if ((this.jdField_a_of_type_Umy != null) && (this.jdField_a_of_type_Umy.a()))
        {
          bdhb.d(this.jdField_a_of_type_Umy.a());
          this.jdField_a_of_type_Umy.a();
        }
        if (this.jdField_a_of_type_Ajti.a() != null)
        {
          this.jdField_a_of_type_Ajti.a(paramxkl);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "exists audio_url = " + str2 + ", path = " + paramxkl);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getCurFragmentMusic - urMusic is null");
        }
      }
      if (!bdin.g(BaseApplication.getContext()))
      {
        f();
        QQToast.a(BaseApplication.getContext(), 2131695729, 0).a();
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
      this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramxkl);
      if ((this.jdField_a_of_type_Umy != null) && (this.jdField_a_of_type_Umy.a()))
      {
        bdhb.d(this.jdField_a_of_type_Umy.a());
        this.jdField_a_of_type_Umy.a();
      }
      ThreadManager.post(new P2VEditMusicDialog.3(this, str2), 5, null, true);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_Ajti.b();
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
      this.jdField_c_of_type_AndroidWidgetTextView.setText(xkk.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(xkk.a(i, true));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    xkl localxkl = this.jdField_a_of_type_Ajti.a();
    if (localxkl != null)
    {
      localxkl.jdField_d_of_type_Int = ((int)(localxkl.f * (paramInt3 / paramInt1)));
      localxkl.e = (localxkl.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      b(localxkl.jdField_d_of_type_Int, localxkl.e);
    }
  }
  
  public void b(xkl paramxkl)
  {
    if ((!TextUtils.isEmpty(paramxkl.jdField_d_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramxkl.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramxkl.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Ajti.a(paramxkl);
    a(paramxkl);
    wxk.a("0X80076D6");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ajti.c();
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
    this.jdField_a_of_type_Xjy.a();
    if ((this.jdField_a_of_type_Umy != null) && (this.jdField_a_of_type_Umy.a()))
    {
      bdhb.d(this.jdField_a_of_type_Umy.a());
      this.jdField_a_of_type_Umy.a();
    }
    ((uus)((uvb)uwa.a(20)).a(1)).b(this.jdField_a_of_type_Uva);
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
    xkl localxkl = this.jdField_a_of_type_Ajti.a();
    if ((localxkl != null) && (localxkl.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Xki != null) && (this.jdField_a_of_type_Xki.a(localxkl) > 0) && (!localxkl.equals(this.jdField_a_of_type_Xki.a())))
    {
      this.jdField_a_of_type_Xki.a(localxkl);
      this.jdField_a_of_type_Xki.notifyDataSetChanged();
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
    case 2131370877: 
      g();
      dismiss();
      return;
    case 2131370878: 
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
    if (this.jdField_a_of_type_Xki != null)
    {
      paramAdapterView = (xkl)this.jdField_a_of_type_Xki.getItem(paramInt);
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
        this.jdField_a_of_type_Xki.a(paramAdapterView);
        this.jdField_a_of_type_Xki.notifyDataSetChanged();
        if (paramInt >= this.jdField_a_of_type_Xki.a()) {
          break;
        }
        b();
        if (paramAdapterView.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_Ajti.a(paramAdapterView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          return;
        }
        if (paramAdapterView.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_Ajti.a(paramAdapterView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          return;
        }
      } while (paramAdapterView.jdField_b_of_type_Int != 2);
      if (!bdin.g(BaseApplication.getContext()))
      {
        f();
        QQToast.a(BaseApplication.getContext(), 2131695729, 0).a();
        return;
      }
      this.jdField_a_of_type_Ajti.a();
    } while ((this.jdField_a_of_type_Ajti.a()) || (!(getContext() instanceof ContextThemeWrapper)) || (!(((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity)));
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
    this.jdField_a_of_type_Ajti.a(paramAdapterView);
    a(paramAdapterView);
    wxj.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */