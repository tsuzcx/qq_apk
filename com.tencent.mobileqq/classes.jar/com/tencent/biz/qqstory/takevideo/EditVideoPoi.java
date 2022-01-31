package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import oej;
import oek;
import oen;
import oeo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoPoi
  extends EditVideoPart
  implements View.OnClickListener, LbsManager.POIListRequestCallback, HttpWebCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  public double a;
  public long a;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public LbsManager.POIListRequestSession a;
  QQStoryPoiListAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = null;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  public ArrayList a;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  public double b;
  View jdField_b_of_type_AndroidViewView = null;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  View c = null;
  View d = null;
  
  public EditVideoPoi(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = null;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
  }
  
  private TroopBarPOI a(List paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
      if (localTroopBarPOI.c.equals(paramString)) {
        return localTroopBarPOI;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.OverScrollViewTag localOverScrollViewTag = (Contacts.OverScrollViewTag)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (localOverScrollViewTag != null)
      {
        localOverScrollViewTag.a = false;
        new Handler(Looper.getMainLooper()).postDelayed(new oeo(this), 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  private void a(List paramList, String paramString)
  {
    String str = TroopBarPOI.a(paramString);
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, str);
      paramList = paramString;
      if (paramString == null)
      {
        paramList = new TroopBarPOI("-1", "", str, 0, "", 0, "");
        this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramList;
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363227));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371774);
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371775);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371777));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371778));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.c.setOnClickListener(this);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363363)).setText("所在位置");
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371776));
      h();
      j();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new oej(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = new QQStoryPoiListAdapter(a());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
  }
  
  public void H_()
  {
    a(false);
  }
  
  public void I_()
  {
    i();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364328));
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult.");
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
    if (!isValidate()) {
      return;
    }
    boolean bool;
    if ((paramInt == 0) && (paramPOIListRequestSession != null)) {
      if (!paramPOIListRequestSession.a())
      {
        bool = true;
        b(bool);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession != null) && (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b())) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a());
        }
        SLog.a("Q.qqstory.publish.edit.EditVideoPoi", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label267;
          }
          a(false, false);
        }
        label193:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
          break label287;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c)) {
          break label276;
        }
        paramPOIListRequestSession = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
        label221:
        a(1, new String[] { paramPOIListRequestSession });
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      StoryReportor.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      label267:
      a(true, false);
      break label193;
      label276:
      paramPOIListRequestSession = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
      break label221;
      label287:
      a(0, new String[0]);
      continue;
      a(3, new String[0]);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      break;
    }
    do
    {
      do
      {
        return;
        k();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        a(true);
      } while (!(paramObject instanceof EditVideoDoodle.LocationCallback));
      paramObject = (EditVideoDoodle.LocationCallback)paramObject;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback);
      paramObject = paramObject.jdField_a_of_type_JavaLangString;
      a(this.jdField_b_of_type_JavaUtilArrayList, paramObject);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
  }
  
  protected void a(int paramInt, String... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (AppSetting.b) {}
      return;
      a(2131432491);
      continue;
      a(2131432490);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        QQToast.a(a(), paramVarArgs[0], 1).a();
        continue;
        a(2131432489);
        continue;
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (TextUtils.isEmpty(paramVarArgs[0]))) {
          break;
        }
        if (TextUtils.isEmpty(paramVarArgs[0]))
        {
          a(3, new String[0]);
          return;
        }
        paramVarArgs = paramVarArgs[0];
      }
    }
    a(0, new String[0]);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter == null)) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
    {
      paramAdapterView = "2";
      paramView.a("change_poi", 0, 0, new String[] { paramAdapterView });
      VideoEditReport.a("0X80076D0");
      VideoEditReport.b("0X80075E5");
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
      paramView = (EditVideoPoiPickerCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
        break label190;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c)) {
        break label179;
      }
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
      label139:
      a(1, new String[] { paramAdapterView });
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    for (;;)
    {
      b();
      return;
      paramAdapterView = "1";
      break;
      label179:
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
      break label139;
      label190:
      a(0, new String[0]);
      if (paramView != null) {
        paramView.a(null);
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (!isValidate()) {}
    while (3 != paramInt) {
      return;
    }
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("result");
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "poiList = " + paramJSONObject);
        }
        if (paramJSONObject == null) {
          continue;
        }
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label334;
        }
        bool = true;
        b(bool);
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("refresh_all_poi"))) {
          break label340;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label319;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.publish.edit.EditVideoPoi", 2, paramJSONObject.toString());
        continue;
        paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c;
        continue;
        a(0, new String[0]);
        return;
      }
      if (i < paramJSONObject.length())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(i)));
        if ((paramInt != 0) && (i == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.c))
          {
            paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.d;
            a(1, new String[] { paramJSONObject });
            return;
          }
        }
        a(3, new String[0]);
        return;
        label319:
        i = 0;
        continue;
      }
      i += 1;
      continue;
      label334:
      boolean bool = false;
      continue;
      label340:
      paramInt = 0;
    }
  }
  
  void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "requestSosoPoi");
    a(2, new String[0]);
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new oen(this, "NewStoryTakeVideoActivity", paramBoolean);
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public boolean a()
  {
    return b();
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131363921);
    if (paramBoolean)
    {
      localTextView.setText(2131434333);
      return;
    }
    localTextView.setText(2131434329);
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void e()
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "requestPoiList");
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = LocationUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a);
    if (localBasicLocation != null) {
      localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, this);
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2130969238, null, false));
    }
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new oek(this));
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null)
    {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  protected void j()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2130969238, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131363283);
      TextView localTextView1 = (TextView)this.d.findViewById(2131363921);
      TextView localTextView2 = (TextView)this.d.findViewById(2131363922);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131363031);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131434329);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363227: 
      paramView = (EditVideoPoiPickerCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramView != null) {
        paramView.a();
      }
      b();
      return;
    case 2131371774: 
    case 2131371775: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(4, this.jdField_a_of_type_MqqUtilWeakReference.get());
      return;
    }
    e();
    a(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoi
 * JD-Core Version:    0.7.0.1
 */