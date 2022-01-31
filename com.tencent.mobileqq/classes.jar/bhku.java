import android.content.res.Resources;
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
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiSearchUI.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bhku
  implements View.OnClickListener, behi
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new bhkx(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private bhky jdField_a_of_type_Bhky;
  bitv jdField_a_of_type_Bitv = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  WeakReference<bign> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = null;
  ssf jdField_a_of_type_Ssf = ssf.a();
  View b;
  View c;
  View d = null;
  View e = null;
  View f = null;
  View g = null;
  View h;
  
  private void g()
  {
    urk.b("FacePoiSearchUI", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_Ssf.a(str);
    if (TextUtils.isEmpty(str))
    {
      urk.c("FacePoiSearchUI", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Bitv.notifyDataSetChanged();
      d();
      return;
    }
    srz localsrz = (srz)sqg.a(9);
    sry localsry = srz.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localsry = vls.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localsry != null) {
      localsrz.a(localsry, this.jdField_a_of_type_Ssf, new bhkw(this, str));
    }
    if (this.jdField_a_of_type_Ssf.b())
    {
      c();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public bign a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      throw new IllegalStateException("EditVideoPoiPickerCallback is null");
    }
    return (bign)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131306114);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131302594));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131298309);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306113));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131306122);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131309981);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131309944);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309945));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Bitv = new bitv(this.h.getContext());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Bitv.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bhkv(this));
      b();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bitv);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.post(new FacePoiSearchUI.2(this));
    this.d.setVisibility(4);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("FacePoiSearchUI rootView can't be null");
    }
    this.h = paramView;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.h.findViewById(2131307633));
  }
  
  public void a(bhky parambhky)
  {
    this.jdField_a_of_type_Bhky = parambhky;
  }
  
  public void a(bign parambign)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambign);
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.g.setVisibility(0);
    paramString = this.h.getResources().getString(2131633888, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131309308);
    if (paramBoolean)
    {
      localTextView.setText(2131653911);
      return;
    }
    localTextView.setText(2131653906);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      beex.b(this.h);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.h.getContext()).inflate(2131493891, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131309306);
      TextView localTextView1 = (TextView)this.d.findViewById(2131309308);
      TextView localTextView2 = (TextView)this.d.findViewById(2131309314);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131309309);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131653906);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  void c()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.g.setVisibility(4);
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      beex.b(this.h);
      return;
      a();
      e();
    } while (this.jdField_a_of_type_Bhky == null);
    this.jdField_a_of_type_Bhky.bd_();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView = (bign)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_Bhky != null)) {
        this.jdField_a_of_type_Bhky.bd_();
      }
      beex.b(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhku
 * JD-Core Version:    0.7.0.1
 */