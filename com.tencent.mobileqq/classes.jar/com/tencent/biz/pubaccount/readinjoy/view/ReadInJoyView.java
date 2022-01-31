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
    this.jdField_e_of_type_AndroidViewView = this.n.findViewById(2131366879);
    this.jdField_f_of_type_AndroidViewView = this.n.findViewById(2131366878);
    this.g = this.n.findViewById(2131362754);
    this.l = this.n.findViewById(2131366851);
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
    this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.n.findViewById(2131366876)).inflate();
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366857);
    this.jdField_c_of_type_AndroidViewView = this.n.findViewById(2131366858);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.n.findViewById(2131366859));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[0] = ((FixSizeImageView)this.n.findViewById(2131366860));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[1] = ((FixSizeImageView)this.n.findViewById(2131366861));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[2] = ((FixSizeImageView)this.n.findViewById(2131366862));
    this.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[3] = ((FixSizeImageView)this.n.findViewById(2131366863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366865));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366866));
    this.jdField_d_of_type_AndroidViewView = this.n.findViewById(2131366864);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend = ((ComponentHeaderFriendRecommend)this.n.findViewById(2131366867));
  }
  
  public boolean a()
  {
    if (this.m != null) {
      return true;
    }
    ViewStub localViewStub = (ViewStub)this.n.findViewById(2131366855);
    if (localViewStub == null) {
      return false;
    }
    this.m = localViewStub.inflate();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366874));
    return true;
  }
  
  public void b()
  {
    if (this.h != null) {
      return;
    }
    this.h = ((ViewStub)this.n.findViewById(2131366854)).inflate();
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)this.n.findViewById(2131366868));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)this.n.findViewById(2131366870));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)this.n.findViewById(2131366872));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)this.n.findViewById(2131366873));
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = this.n.findViewById(2131366869);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = this.n.findViewById(2131366871);
  }
  
  public void c()
  {
    if (this.i != null) {
      return;
    }
    this.i = ((ViewStub)this.n.findViewById(2131366853)).inflate();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366856));
  }
  
  public void d()
  {
    if (this.j != null) {
      return;
    }
    this.j = ((ViewStub)this.n.findViewById(2131366852)).inflate();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366850));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.n.findViewById(2131366849));
    this.k = this.n.findViewById(2131366848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView
 * JD-Core Version:    0.7.0.1
 */