package com.tencent.mobileqq.activity.photo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.weiyun.utils.PreferenceUtils;
import java.util.ArrayList;
import java.util.List;
import wvq;
import wvr;

public class AlbumListActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public AlbumListAdapter a;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  int jdField_c_of_type_Int = 100;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  int d;
  public boolean d;
  int jdField_e_of_type_Int = -1;
  boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = true;
  boolean g;
  public boolean h = false;
  public boolean i = false;
  boolean j = false;
  private boolean k;
  private boolean l;
  
  public AlbumListActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.g = localIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_f_of_type_Int = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("PhotoConst.QZONE_ALBUM_NUM", 0L);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = ((MediaFileFilter)MediaFileFilter.a.get(this.jdField_f_of_type_Int));
    this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = new DynamicImageMediaFileFilter(MediaFileFilter.b);
      this.jdField_f_of_type_Int = 1;
    }
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("peak.myUin");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.getCurrentAccountUin();
      if (this.jdField_a_of_type_JavaLangString == null) {
        throw new RuntimeException("must set MY_UIN");
      }
    }
    this.i = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", false);
    this.h = localIntent.getBooleanExtra("key_is_for_health", false);
    this.l = localIntent.getBooleanExtra("PhotoConst.IS_FROM_WEIYUN", false);
    String str;
    if (this.l)
    {
      str = PreferenceUtils.a(getApplicationContext(), this.jdField_a_of_type_JavaLangString, "pref_select_album");
      if (!TextUtils.isEmpty(str)) {
        break label305;
      }
    }
    label305:
    for (this.jdField_a_of_type_JavaUtilList = new ArrayList();; this.jdField_a_of_type_JavaUtilList = PreferenceUtils.a(str))
    {
      this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false);
      this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false);
      this.j = localIntent.getBooleanExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", false);
      if (this.j)
      {
        this.jdField_c_of_type_Int = localIntent.getIntExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", 100);
        this.jdField_d_of_type_Int = localIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", 0);
        this.jdField_e_of_type_Int = localIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", -1);
        this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS");
      }
      return;
    }
  }
  
  @TargetApi(14)
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131362840);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter = new AlbumListAdapter(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(this.jdField_a_of_type_Long);
    if (this.j) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131369489));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new wvr(this, null));
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363428));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131432420);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.l) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("确定");
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new wvq(this));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("取消");
    }
  }
  
  protected boolean a()
  {
    return false;
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
    for (int m = ((ArrayList)localObject1).size();; m = 0)
    {
      StatisticConstants.b((Intent)localObject2, m);
      if (this.g) {
        break;
      }
      finish();
      AlbumUtil.a();
      AlbumUtil.a(this, false, false);
      return;
    }
    localObject1 = getIntent();
    localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    String str1 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    if (localObject2 == null)
    {
      QQToast.a(this, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      return;
    }
    ((Intent)localObject1).removeExtra("PhotoConst.PHOTO_PATHS");
    ((Intent)localObject1).removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ((Intent)localObject1).addFlags(603979776);
    if (((String)localObject2).startsWith("com.qzone"))
    {
      QzonePluginProxyActivity.a((Intent)localObject1, (String)localObject2);
      ((Intent)localObject1).putExtra("cleartop", true);
      QZoneHelper.a(this, this.jdField_a_of_type_JavaLangString, (Intent)localObject1, -1);
    }
    for (;;)
    {
      finish();
      AlbumUtil.a(this, false, false);
      return;
      ((Intent)localObject1).setClassName(str1, (String)localObject2);
      if (!((Intent)localObject1).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        startActivity((Intent)localObject1);
      }
      else
      {
        ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_NAME");
        str1 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
        String str2 = ((Intent)localObject1).getStringExtra("PhotoConst.UIN");
        if ("qzone_plugin.apk".equals(str1))
        {
          ((Intent)localObject1).putExtra("qzone_plugin_activity_name", (String)localObject2);
          QZoneHelper.a(this, str2, (Intent)localObject1, 2);
        }
        else if ("qqfav.apk".equals(str1))
        {
          QfavHelper.a(this, this.jdField_a_of_type_JavaLangString, (Intent)localObject1, -1);
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
    super.setContentView(2130970192);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131558591);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    a();
    b();
  }
  
  protected void onDestroy()
  {
    AlbumThumbManager.a(this).a();
    if (!this.k) {
      AlbumUtil.c();
    }
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