import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aysk
  extends ayta
  implements aysg
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView;
  private WeakReference<aysn> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public aysk(ayso paramayso, Context paramContext)
  {
    super(paramayso, paramContext);
  }
  
  public View a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561257, null, false);
    this.jdField_a_of_type_AndroidViewView = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362811));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    ((ArkAppRootLayout)paramContext).setDisableParentReturn(false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.b = false;
    a(1);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    aysn localaysn;
    do
    {
      return;
      localaysn = (aysn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localaysn == null);
    localaysn.a(paramInt);
  }
  
  public void a(aysi paramaysi)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView == null) || (paramaysi == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView.a(paramaysi, this);
  }
  
  public void a(aysn paramaysn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaysn);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.b = true;
    a(1);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    TextView localTextView;
    label124:
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeView", 2, "onLoadFailed, show no result");
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        a(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aysl(this));
      localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131375592);
      if (localTextView != null)
      {
        if (paramString != null) {
          break label169;
        }
        localTextView.setText(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getString(2131690293));
      }
      paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131375585);
    } while (paramString == null);
    if (paramBoolean) {}
    for (paramInt = 2130838561;; paramInt = 2130838560)
    {
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      break;
      label169:
      localTextView.setText(paramString);
      break label124;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (this.b)
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Boolean) {
          bool = false;
        }
      }
    }
    super.a(bool);
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView.a();
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView = null;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    super.d();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysk
 * JD-Core Version:    0.7.0.1
 */