import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.10;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.4;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.5;

public class biur
  extends Fragment
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bbgu jdField_a_of_type_Bbgu;
  private bitf jdField_a_of_type_Bitf;
  private bitx jdField_a_of_type_Bitx;
  private bivd jdField_a_of_type_Bivd;
  bivj jdField_a_of_type_Bivj;
  private AEStoryGIFPreviewActivity jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private float c = 0.82F;
  private float d = 0.16F;
  
  private int a(char paramChar)
  {
    if ((paramChar == '\n') || (paramChar == '\r')) {
      return 0;
    }
    if (paramChar < '') {
      return 1;
    }
    return 2;
  }
  
  public static biur a(String paramString, boolean paramBoolean)
  {
    biur localbiur = new biur();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    localbiur.setArguments(localBundle);
    return localbiur;
  }
  
  public static biur a(String paramString, boolean paramBoolean, View paramView)
  {
    paramString = a(paramString, paramBoolean);
    paramString.a(paramView);
    return paramString;
  }
  
  private void a()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).toggleSoftInput(1, 2);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void a(bivd parambivd)
  {
    this.jdField_a_of_type_Bivd = parambivd;
  }
  
  private void a(String paramString1, String paramString2)
  {
    bizx.a().i(paramString1);
    bizx.a().j(paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramBoolean)
    {
      if (str.equals(""))
      {
        if (this.jdField_a_of_type_Bitf != null) {
          this.jdField_a_of_type_Bitf.d();
        }
        this.jdField_a_of_type_Bivj.a();
        a("none", this.jdField_a_of_type_Bitx.a());
        getFragmentManager().popBackStack();
        return;
      }
      d();
      b(str);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h();
        Object localObject = (bivs)this.jdField_a_of_type_Bivj.c().a();
        if ((localObject != null) && (((bivs)localObject).jdField_a_of_type_JavaLangString != null)) {
          bbdx.a(((bivs)localObject).jdField_a_of_type_JavaLangString);
        }
        localObject = new bivz(this.jdField_b_of_type_JavaLangString);
        b();
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((bivz)localObject).a(str, 55, this.jdField_a_of_type_Bitx.a(), this.jdField_a_of_type_Bitx.b(), baxn.a(getActivity(), 4.0F), this.jdField_a_of_type_Float, this.c, this.jdField_b_of_type_Float, this.d);
        ((bivz)localObject).a(new biux(this, str));
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.4(this));
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    e();
  }
  
  private void b()
  {
    if (((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371163) != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().indexOf('\n') > 0))
    {
      this.c = 0.73F;
      this.d = 0.3F;
    }
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.a();
    biqw localbiqw = (biqw)localAppInterface.getBusinessHandler(3);
    localAppInterface.addObserver(new biut(this, localAppInterface));
    localbiqw.c(paramString);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h();
        getFragmentManager().popBackStack();
        return;
      }
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.5(this));
      return;
    }
    e();
  }
  
  private void c()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 2131755791);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559121);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 230);
    this.jdField_a_of_type_Bbgu.setMessage(ajya.a(2131699983));
    this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbgu.setPositiveButton(ajya.a(2131699982), new biuy(this));
    this.jdField_a_of_type_Bbgu.show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bivj = ((bivj)bijo.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity).a(bivj.class));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375339));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375424));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363683));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375555));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_Bitx = new bitx(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Bitx.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bitx);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377090).setOnClickListener(new biuz(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377091).setOnClickListener(new biva(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bivb(this));
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_Bitx.a();
    int i = this.jdField_a_of_type_Bitx.a();
    String str3 = this.jdField_a_of_type_Bitx.b();
    if (this.jdField_a_of_type_Bitf != null) {
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i));
    }
    this.jdField_a_of_type_Bivj.a(str1, i);
    a(str1, str2);
  }
  
  protected int a()
  {
    return 2131558525;
  }
  
  public void a(View paramView1, View paramView2, View paramView3)
  {
    paramView1.getViewTreeObserver().addOnGlobalLayoutListener(new biuu(this, paramView1, paramView3, paramView2));
  }
  
  public void a(bitf parambitf)
  {
    this.jdField_a_of_type_Bitf = parambitf;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376299));
    this.jdField_a_of_type_Bitx.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor(paramString));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
    if ((this.jdField_a_of_type_AndroidWidgetEditText.length() > 0) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new bivc(this) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new biuv(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_JavaLangString = getArguments().getString("KEY_PNG_DIR_PATH");
    this.jdField_b_of_type_Boolean = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
    this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity = ((AEStoryGIFPreviewActivity)getActivity());
    f();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    g();
    if (this.jdField_a_of_type_Bitf != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bitf.a();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bitf.a();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bitx.a());
      a();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Bivj.b().a());
    }
  }
  
  public void onPause()
  {
    super.onPause();
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new bius(this));
    a(new biuw(this));
    a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.findViewById(2131375339), this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_b_of_type_AndroidWidgetRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biur
 * JD-Core Version:    0.7.0.1
 */