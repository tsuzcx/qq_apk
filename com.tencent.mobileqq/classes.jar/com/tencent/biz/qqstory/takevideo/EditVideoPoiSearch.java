package com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.poilist.QQStoryPoiListAdapter;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import ogi;
import ogj;
import ogk;
import ogl;

public class EditVideoPoiSearch
  extends EditVideoPart
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ogl(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public LbsManager.POIListRequestSession a;
  public QQStoryPoiListAdapter a;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public ArrayList a;
  View b;
  View c;
  public View d = null;
  View e = null;
  View f = null;
  View g = null;
  
  public EditVideoPoiSearch(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = LbsManager.POIListRequestSession.a();
  }
  
  private void l()
  {
    SLog.b("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a(str);
    if (TextUtils.isEmpty(str))
    {
      SLog.c("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.notifyDataSetChanged();
      k();
      return;
    }
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = LocationUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a);
    if (localBasicLocation != null) {
      localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, new ogk(this, str));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b())
    {
      j();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364353));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      return;
    }
    if ((paramObject instanceof EditVideoPoiPickerCallback)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((EditVideoPoiPickerCallback)paramObject);
    }
    e();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.post(new ogi(this));
    this.d.setVisibility(4);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      h();
      paramView = (EditVideoPoiPickerCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.g.setVisibility(0);
    paramString = a().getString(2131432091, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131363944);
    if (paramBoolean)
    {
      localTextView.setText(2131434350);
      return;
    }
    localTextView.setText(2131434346);
  }
  
  public boolean a()
  {
    return b();
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
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(3, this.jdField_a_of_type_JavaLangRefWeakReference.get());
        InputMethodUtil.b(a().a());
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131371951);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371949));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131371950);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371946));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371952);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131371953);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131371954);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371955));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter = new QQStoryPoiListAdapter(a());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new ogj(this));
      i();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPoilistQQStoryPoiListAdapter);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c.setOnClickListener(this);
    }
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    }
    InputMethodUtil.b(a().a());
  }
  
  protected void i()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2130969239, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131363301);
      TextView localTextView1 = (TextView)this.d.findViewById(2131363944);
      TextView localTextView2 = (TextView)this.d.findViewById(2131363945);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131363049);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131434346);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  void j()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.g.setVisibility(4);
  }
  
  void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371951: 
    case 2131371952: 
      InputMethodUtil.b(a().a());
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch
 * JD-Core Version:    0.7.0.1
 */