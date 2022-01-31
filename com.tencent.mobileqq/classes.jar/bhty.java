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
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.AEStoryGIFPreviewActivity;
import dov.com.qq.im.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.giftext.fragment.AEGIFTextEditFragment.10;
import dov.com.qq.im.giftext.fragment.AEGIFTextEditFragment.4;
import dov.com.qq.im.giftext.fragment.AEGIFTextEditFragment.5;

public class bhty
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
  private bafb jdField_a_of_type_Bafb;
  private bhsk jdField_a_of_type_Bhsk;
  private bhtd jdField_a_of_type_Bhtd;
  private bhuk jdField_a_of_type_Bhuk;
  bhuq jdField_a_of_type_Bhuq;
  private AEStoryGIFPreviewActivity jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity;
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
  
  public static bhty a(String paramString, boolean paramBoolean)
  {
    bhty localbhty = new bhty();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    localbhty.setArguments(localBundle);
    return localbhty;
  }
  
  public static bhty a(String paramString, boolean paramBoolean, View paramView)
  {
    paramString = a(paramString, paramBoolean);
    paramString.a(paramView);
    return paramString;
  }
  
  private void a()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.getSystemService("input_method")).toggleSoftInput(1, 2);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(bhuk parambhuk)
  {
    this.jdField_a_of_type_Bhuk = parambhuk;
  }
  
  private void a(String paramString1, String paramString2)
  {
    bhcm.a().h(paramString1);
    bhcm.a().i(paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramBoolean)
    {
      if (str.equals(""))
      {
        if (this.jdField_a_of_type_Bhsk != null) {
          this.jdField_a_of_type_Bhsk.d();
        }
        this.jdField_a_of_type_Bhuq.a();
        a("none", this.jdField_a_of_type_Bhtd.a());
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
        Object localObject = (bial)this.jdField_a_of_type_Bhuq.c().a();
        if ((localObject != null) && (((bial)localObject).jdField_a_of_type_JavaLangString != null)) {
          bace.a(((bial)localObject).jdField_a_of_type_JavaLangString);
        }
        localObject = new bias(this.jdField_b_of_type_JavaLangString);
        b();
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        ((bias)localObject).a(str, 55, this.jdField_a_of_type_Bhtd.a(), this.jdField_a_of_type_Bhtd.b(), azvv.a(getActivity(), 4.0F), this.jdField_a_of_type_Float, this.c, this.jdField_b_of_type_Float, this.d);
        ((bias)localObject).a(new bhue(this, str));
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.4(this));
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    e();
  }
  
  private void b()
  {
    if (((AEGIFOutlineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305470) != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().indexOf('\n') > 0))
    {
      this.c = 0.73F;
      this.d = 0.3F;
    }
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.a();
    avzm localavzm = (avzm)localAppInterface.getBusinessHandler(3);
    localAppInterface.addObserver(new bhua(this, localAppInterface));
    localavzm.c(paramString);
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
      this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.5(this));
      return;
    }
    e();
  }
  
  private void c()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity, 2131690181);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493552);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity, 230);
    this.jdField_a_of_type_Bafb.setMessage(ajjy.a(2131634184));
    this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bafb.setPositiveButton(ajjy.a(2131634183), new bhuf(this));
    this.jdField_a_of_type_Bafb.show();
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bhuq = ((bhuq)bhur.a(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity).a(bhuq.class));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309588));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309668));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298132));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131309793));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_Bhtd = new bhtd(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Bhtd.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhtd);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311277).setOnClickListener(new bhug(this));
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311278).setOnClickListener(new bhuh(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bhui(this));
  }
  
  private void h()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_a_of_type_Bhtd.a();
    int i = this.jdField_a_of_type_Bhtd.a();
    String str3 = this.jdField_a_of_type_Bhtd.b();
    if (this.jdField_a_of_type_Bhsk != null) {
      this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i));
    }
    this.jdField_a_of_type_Bhuq.a(str1, i);
    a(str1, str2);
  }
  
  protected int a()
  {
    return 2131492974;
  }
  
  public void a(View paramView1, View paramView2)
  {
    paramView1.getViewTreeObserver().addOnGlobalLayoutListener(new bhub(this, paramView1, paramView2));
  }
  
  public void a(bhsk parambhsk)
  {
    this.jdField_a_of_type_Bhsk = parambhsk;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131310505));
    this.jdField_a_of_type_Bhtd.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor(paramString));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
    if ((this.jdField_a_of_type_AndroidWidgetEditText.length() > 0) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new bhuj(this) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bhuc(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_JavaLangString = getArguments().getString("KEY_PNG_DIR_PATH");
    this.jdField_b_of_type_Boolean = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
    this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity = ((AEStoryGIFPreviewActivity)getActivity());
    f();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    g();
    if (this.jdField_a_of_type_Bhsk != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bhsk.a();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bhsk.a();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bhtd.a());
      a();
      return this.jdField_a_of_type_AndroidViewViewGroup;
      this.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_Bhuq.b().a());
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
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new bhtz(this));
    a(new bhud(this));
    a(this.jdField_a_of_type_DovComQqImAEStoryGIFPreviewActivity.findViewById(2131309588), this.jdField_b_of_type_AndroidWidgetRelativeLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhty
 * JD-Core Version:    0.7.0.1
 */