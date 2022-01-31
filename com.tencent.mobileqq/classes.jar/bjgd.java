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

public class bjgd
  implements View.OnClickListener, bfpt
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new bjgg(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private bjgh jdField_a_of_type_Bjgh;
  bkkz jdField_a_of_type_Bkkz = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  WeakReference<bjxz> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = null;
  tey jdField_a_of_type_Tey = tey.a();
  View b;
  View c;
  View d = null;
  View e = null;
  View f = null;
  View g = null;
  View h;
  
  private void g()
  {
    ved.b("FacePoiSearchUI", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_Tey.a(str);
    if (TextUtils.isEmpty(str))
    {
      ved.c("FacePoiSearchUI", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Bkkz.notifyDataSetChanged();
      d();
      return;
    }
    tes localtes = (tes)tcz.a(9);
    ter localter = tes.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localter = vyl.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localter != null) {
      localtes.a(localter, this.jdField_a_of_type_Tey, new bjgf(this, str));
    }
    if (this.jdField_a_of_type_Tey.b())
    {
      c();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public bjxz a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      throw new IllegalStateException("EditVideoPoiPickerCallback is null");
    }
    return (bjxz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131371811);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368215));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363863);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371810));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371819);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131375744);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131375707);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375708));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Bkkz = new bkkz(this.h.getContext());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Bkkz.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bjge(this));
      b();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bkkz);
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
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.h.findViewById(2131373348));
  }
  
  public void a(bjgh parambjgh)
  {
    this.jdField_a_of_type_Bjgh = parambjgh;
  }
  
  public void a(bjxz parambjxz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjxz);
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
    paramString = this.h.getResources().getString(2131699687, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131375055);
    if (paramBoolean)
    {
      localTextView.setText(2131719806);
      return;
    }
    localTextView.setText(2131719801);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      bfni.b(this.h);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(this.h.getContext()).inflate(2131559459, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131375053);
      TextView localTextView1 = (TextView)this.d.findViewById(2131375055);
      TextView localTextView2 = (TextView)this.d.findViewById(2131375062);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131375056);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131719801);
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
      bfni.b(this.h);
      return;
      a();
      e();
    } while (this.jdField_a_of_type_Bjgh == null);
    this.jdField_a_of_type_Bjgh.aY_();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView = (bjxz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_Bjgh != null)) {
        this.jdField_a_of_type_Bjgh.aY_();
      }
      bfni.b(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgd
 * JD-Core Version:    0.7.0.1
 */