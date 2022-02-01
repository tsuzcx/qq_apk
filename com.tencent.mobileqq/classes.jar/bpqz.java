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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiSearchUI.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bpqz
  implements View.OnClickListener, bljm
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new bprc(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private bprd jdField_a_of_type_Bprd;
  bqtw jdField_a_of_type_Bqtw = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  WeakReference<bqgw> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = null;
  wvg jdField_a_of_type_Wvg = wvg.a();
  View b;
  View c;
  View d = null;
  View e = null;
  View f = null;
  View g = null;
  View h;
  
  private void g()
  {
    yuk.b("FacePoiSearchUI", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_Wvg.a(str);
    if (TextUtils.isEmpty(str))
    {
      yuk.c("FacePoiSearchUI", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Bqtw.notifyDataSetChanged();
      d();
      return;
    }
    wva localwva = (wva)wth.a(9);
    wuz localwuz = wva.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localwuz = zos.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localwuz != null) {
      localwva.a(localwuz, this.jdField_a_of_type_Wvg, new bprb(this, str));
    }
    if (this.jdField_a_of_type_Wvg.b())
    {
      c();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public bqgw a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      throw new IllegalStateException("EditVideoPoiPickerCallback is null");
    }
    return (bqgw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131372839);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368754));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131364166);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372838));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131372847);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131377212);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131377169);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377170));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Bqtw = new bqtw(this.h.getContext());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Bqtw.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bpra(this));
      b();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bqtw);
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
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.h.findViewById(2131374687));
  }
  
  public void a(bprd parambprd)
  {
    this.jdField_a_of_type_Bprd = parambprd;
  }
  
  public void a(bqgw parambqgw)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqgw);
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
    paramString = this.h.getResources().getString(2131698600, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131376444);
    if (paramBoolean)
    {
      localTextView.setText(2131718369);
      return;
    }
    localTextView.setText(2131718364);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      blgx.b(this.h);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.h.getContext()).inflate(2131559652, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131376442);
      TextView localTextView1 = (TextView)this.d.findViewById(2131376444);
      TextView localTextView2 = (TextView)this.d.findViewById(2131376450);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131376445);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131718364);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      blgx.b(this.h);
      continue;
      a();
      e();
      if (this.jdField_a_of_type_Bprd != null) {
        this.jdField_a_of_type_Bprd.aW_();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView = (bqgw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_Bprd != null)) {
        this.jdField_a_of_type_Bprd.aW_();
      }
      blgx.b(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqz
 * JD-Core Version:    0.7.0.1
 */