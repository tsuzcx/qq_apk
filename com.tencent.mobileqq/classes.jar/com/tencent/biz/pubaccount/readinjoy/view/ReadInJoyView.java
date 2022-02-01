package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.widget.FixSizeImageView;

public class ReadInJoyView
{
  public View a;
  public TextView a;
  public ComponentHeaderFriendRecommend a;
  public KandianUrlImageView a;
  public View[] a;
  public TextView[] a;
  public FixSizeImageView[] a;
  public View b;
  public TextView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  public View e;
  public TextView e;
  public View f;
  public TextView f;
  public View g;
  public View h;
  public View i;
  public View j;
  public View k;
  public View l;
  public View m;
  private View n;
  
  public ReadInJoyView(View paramView)
  {
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView = new FixSizeImageView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[4];
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[2];
    this.n = paramView;
    e();
  }
  
  private void e()
  {
    this.jdField_e_of_type_AndroidViewView = this.n.findViewById(2131380915);
    this.jdField_f_of_type_AndroidViewView = this.n.findViewById(2131378714);
    this.g = this.n.findViewById(2131372115);
    this.l = this.n.findViewById(2131376512);
  }
  
  public View a()
  {
    return this.n;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.n.findViewById(2131376517)).inflate();
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131363059);
    this.jdField_c_of_type_AndroidViewView = this.n.findViewById(2131376524);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.n.findViewById(2131376538));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[0] = ((FixSizeImageView)this.n.findViewById(2131376513));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[1] = ((FixSizeImageView)this.n.findViewById(2131376514));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[2] = ((FixSizeImageView)this.n.findViewById(2131376515));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[3] = ((FixSizeImageView)this.n.findViewById(2131376516));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131376529));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131376520));
    this.jdField_d_of_type_AndroidViewView = this.n.findViewById(2131380935);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend = ((ComponentHeaderFriendRecommend)this.n.findViewById(2131368360));
  }
  
  public boolean a()
  {
    if (this.m != null) {
      return true;
    }
    ViewStub localViewStub = (ViewStub)this.n.findViewById(2131376535);
    if (localViewStub == null) {
      return false;
    }
    this.m = localViewStub.inflate();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131376534));
    return true;
  }
  
  public void b()
  {
    if (this.h != null) {
      return;
    }
    this.h = ((ViewStub)this.n.findViewById(2131369910)).inflate();
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)this.n.findViewById(2131369911));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)this.n.findViewById(2131369913));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)this.n.findViewById(2131369915));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)this.n.findViewById(2131369916));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.n.findViewById(2131369912);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.n.findViewById(2131369914);
  }
  
  public void c()
  {
    if (this.i != null) {
      return;
    }
    this.i = ((ViewStub)this.n.findViewById(2131367574)).inflate();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131367575));
  }
  
  public void d()
  {
    if (this.j != null) {
      return;
    }
    this.j = ((ViewStub)this.n.findViewById(2131365109)).inflate();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131365107));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131365105));
    this.k = this.n.findViewById(2131365068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView
 * JD-Core Version:    0.7.0.1
 */