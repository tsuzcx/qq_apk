package com.tencent.mobileqq.activity.photo;

import agkv;
import agkw;
import agkx;
import agky;
import agkz;
import agla;
import aglb;
import aglo;
import aglv;
import agqd;
import ajya;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axch;
import bbbx;
import bcql;
import bgpw;
import bgyp;
import bjal;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import vtz;

public class AlbumListActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  public long a;
  private agkz jdField_a_of_type_Agkz = new agkz(this);
  public agla a;
  aglv jdField_a_of_type_Aglv;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public XListView a;
  String jdField_a_of_type_JavaLangString;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = null;
  public HashMap<String, LocalMediaInfo> a;
  private List<String> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  int jdField_c_of_type_Int = 100;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  int d;
  public boolean d;
  int e = -1;
  private int f;
  public boolean f;
  boolean g = false;
  boolean h = true;
  boolean i;
  public boolean j;
  public boolean k = false;
  public boolean l = false;
  boolean m = false;
  public boolean n = false;
  boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public boolean r = false;
  public boolean s = false;
  private boolean t;
  private boolean u;
  
  public AlbumListActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.i = localIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_f_of_type_Int = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("PhotoConst.QZONE_ALBUM_NUM", 0L);
    this.jdField_a_of_type_Aglv = ((aglv)aglv.a.get(this.jdField_f_of_type_Int));
    this.g = localIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.g)
    {
      this.jdField_a_of_type_Aglv = new aglo(aglv.d);
      this.jdField_f_of_type_Int = 1;
    }
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("peak.myUin");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_JavaLangString = bjal.a().getCurrentAccountUin();
      if (this.jdField_a_of_type_JavaLangString == null) {
        throw new RuntimeException("must set MY_UIN");
      }
    }
    this.l = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
    this.m = localIntent.getBooleanExtra("from_qqstory_custom_data", false);
    this.n = localIntent.getBooleanExtra("from_qqstory_entrance", false);
    this.s = localIntent.getBooleanExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", false);
    this.k = localIntent.getBooleanExtra("key_is_for_health", false);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false);
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false);
    this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false);
    this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false);
    this.o = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", false);
    if (this.o)
    {
      this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", 100);
      this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", 0);
      this.e = localIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", -1);
      this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS");
    }
    this.q = localIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.p = localIntent.getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false);
    if ((this.jdField_a_of_type_Boolean) && ((!this.q) || (c())))
    {
      NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), axch.class);
      localNewIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.jdField_a_of_type_Agkz);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
    }
    this.r = localIntent.getBooleanExtra("FROM_ARK_CHOOSE_IMAGE", false);
    this.j = localIntent.getBooleanExtra("fromPhotoListPanel", false);
    if (this.j) {
      this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
    }
    this.u = localIntent.getBooleanExtra("PhotoConst.IS_FROM_MINI_APP", false);
  }
  
  @TargetApi(14)
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131375493);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_Agla = new agla(this, this.jdField_a_of_type_Aglv, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Agla.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Agla.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Agla.b(this.m);
    if (this.o) {
      this.jdField_a_of_type_Agla.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131362443));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agla);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new agky(this, null));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    int i1 = getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int i2 = getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new agkv(this, i1, i2));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368457));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131719192);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131700201));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new agkw(this));
  }
  
  private boolean c()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "AioEnableShowQzoneAlbum", 1) == 1;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new agkx(this);
      IntentFilter localIntentFilter = new IntentFilter("AlbumListActivity_finish");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return this.l;
  }
  
  public void onBackPressed()
  {
    Object localObject1 = PresendPicMgr.a(null);
    if (localObject1 != null) {
      ((PresendPicMgr)localObject1).a(1005);
    }
    localObject1 = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    Object localObject2 = getIntent();
    if (localObject1 != null) {}
    for (int i1 = ((ArrayList)localObject1).size();; i1 = 0)
    {
      agqd.b((Intent)localObject2, i1);
      if (this.i) {
        break label240;
      }
      if (b()) {
        vtz.a().a(vtz.a().c());
      }
      if (!this.u) {
        break;
      }
      localObject1 = getIntent();
      if (localObject1 == null) {
        break;
      }
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("AlbumListActivity", 2, String.format("sendPhoto action=%s", new Object[] { localObject2 }));
      }
      localObject3 = new Intent();
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListActivity", 2, String.format("sendPhoto extras=%s", new Object[] { ((Intent)localObject1).getExtras() }));
        }
        ((Intent)localObject3).setComponent(null);
        ((Intent)localObject3).setAction((String)localObject2);
        ((Intent)localObject3).setFlags(getIntent().getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
        sendBroadcast((Intent)localObject3);
        finish();
        bbbx.a(this, false, false);
      }
      return;
    }
    finish();
    bbbx.a();
    bbbx.a(this, false, false);
    return;
    label240:
    localObject1 = getIntent();
    localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    Object localObject3 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if ((((Intent)localObject1).getIntExtra("PhotoConst.KEY_SHOW_TYPE", 0) == 1) && (((Intent)localObject1).getIntExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 0) == 0)) {
      ((Intent)localObject1).putExtra("PhotoConst.KEY_SHOW_TYPE", 0);
    }
    if (localObject2 == null)
    {
      bcql.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    ((Intent)localObject1).removeExtra("PhotoConst.PHOTO_PATHS");
    ((Intent)localObject1).removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ((Intent)localObject1).addFlags(603979776);
    if (((String)localObject2).startsWith("com.qzone"))
    {
      QzonePluginProxyActivity.a((Intent)localObject1, (String)localObject2);
      ((Intent)localObject1).putExtra("cleartop", true);
      bgyp.a(this, this.jdField_a_of_type_JavaLangString, (Intent)localObject1, -1);
    }
    for (;;)
    {
      finish();
      bbbx.a(this, false, false);
      return;
      ((Intent)localObject1).setClassName((String)localObject3, (String)localObject2);
      if (!((Intent)localObject1).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        startActivity((Intent)localObject1);
      }
      else
      {
        ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_NAME");
        localObject3 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
        String str = ((Intent)localObject1).getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(localObject3))
        {
          ((Intent)localObject1).putExtra("qzone_plugin_activity_name", (String)localObject2);
          bgyp.a(this, str, (Intent)localObject1, 2);
        }
        else if ("qqfav.apk".equals(localObject3))
        {
          bgpw.a(this, this.jdField_a_of_type_JavaLangString, (Intent)localObject1, -1);
        }
        else
        {
          QLog.e("AlbumListActivity", 1, "Watermark has been deleted!");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.c();
    super.setContentView(2131560638);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131296375);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    a();
    b();
    d();
  }
  
  public void onDestroy()
  {
    aglb.a(this).a();
    if (!this.t) {
      bbbx.c();
    }
    if (this.jdField_a_of_type_Boolean) {
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(this.jdField_a_of_type_Agkz);
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListActivity
 * JD-Core Version:    0.7.0.1
 */