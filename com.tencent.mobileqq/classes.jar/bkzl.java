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

public class bkzl
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
  private bdfq jdField_a_of_type_Bdfq;
  private bkxy jdField_a_of_type_Bkxy;
  private bkyq jdField_a_of_type_Bkyq;
  private bkzx jdField_a_of_type_Bkzx;
  blad jdField_a_of_type_Blad;
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
  
  public static bkzl a(String paramString, boolean paramBoolean)
  {
    bkzl localbkzl = new bkzl();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    localbkzl.setArguments(localBundle);
    return localbkzl;
  }
  
  public static bkzl a(String paramString, boolean paramBoolean, View paramView)
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
  
  private void a(bkzx parambkzx)
  {
    this.jdField_a_of_type_Bkzx = parambkzx;
  }
  
  private void a(String paramString1, String paramString2)
  {
    bler.a().i(paramString1);
    bler.a().j(paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramBoolean)
    {
      if (str.equals(""))
      {
        if (this.jdField_a_of_type_Bkxy != null) {
          this.jdField_a_of_type_Bkxy.d();
        }
        this.jdField_a_of_type_Blad.a();
        a("none", this.jdField_a_of_type_Bkyq.a());
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
        Object localObject = (blam)this.jdField_a_of_type_Blad.c().a();
        if ((localObject != null) && (((blam)localObject).jdField_a_of_type_JavaLangString != null)) {
          bdcs.a(((blam)localObject).jdField_a_of_type_JavaLangString);
        }
        localObject = new blat(this.jdField_b_of_type_JavaLangString);
        b();
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((blat)localObject).a(str, 55, this.jdField_a_of_type_Bkyq.a(), this.jdField_a_of_type_Bkyq.b(), bcwh.a(getActivity(), 4.0F), this.jdField_a_of_type_Float, this.c, this.jdField_b_of_type_Float, this.d);
        ((blat)localObject).a(new bkzr(this, str));
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
    if (((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371475) != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().indexOf('\n') > 0))
    {
      this.c = 0.73F;
      this.d = 0.3F;
    }
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.a();
    bkvm localbkvm = (bkvm)localAppInterface.getBusinessHandler(3);
    localAppInterface.addObserver(new bkzn(this, localAppInterface));
    localbkvm.c(paramString);
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
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 2131755801);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559164);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 230);
    this.jdField_a_of_type_Bdfq.setMessage(alpo.a(2131700352));
    this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bdfq.setPositiveButton(alpo.a(2131700351), new bkzs(this));
    this.jdField_a_of_type_Bdfq.show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Blad = ((blad)bklq.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity).a(blad.class));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375825));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375909));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363739));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376043));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_Bkyq = new bkyq(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Bkyq.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkyq);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377611).setOnClickListener(new bkzt(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377612).setOnClickListener(new bkzu(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bkzv(this));
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_Bkyq.a();
    int i = this.jdField_a_of_type_Bkyq.a();
    String str3 = this.jdField_a_of_type_Bkyq.b();
    if (this.jdField_a_of_type_Bkxy != null) {
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i));
    }
    this.jdField_a_of_type_Blad.a(str1, i);
    a(str1, str2);
  }
  
  protected int a()
  {
    return 2131558549;
  }
  
  public void a(View paramView1, View paramView2, View paramView3)
  {
    paramView1.getViewTreeObserver().addOnGlobalLayoutListener(new bkzo(this, paramView1, paramView3, paramView2));
  }
  
  public void a(bkxy parambkxy)
  {
    this.jdField_a_of_type_Bkxy = parambkxy;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376802));
    this.jdField_a_of_type_Bkyq.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor(paramString));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
    if ((this.jdField_a_of_type_AndroidWidgetEditText.length() > 0) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new bkzw(this) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bkzp(this));
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
    if (this.jdField_a_of_type_Bkxy != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bkxy.a();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bkxy.a();
    }
    for (;;)
    {
      g();
      a(this.jdField_a_of_type_Bkyq.a());
      a();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Blad.b().a());
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
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new bkzm(this));
    a(new bkzq(this));
    a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.findViewById(2131375825), this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_b_of_type_AndroidWidgetRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzl
 * JD-Core Version:    0.7.0.1
 */