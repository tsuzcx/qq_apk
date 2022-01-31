import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbjc
  implements bcuq
{
  public int a;
  protected Context a;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected GridView a;
  public LinearLayout a;
  protected TextView a;
  protected bbji a;
  private bcuq jdField_a_of_type_Bcuq;
  protected bfol a;
  public ElasticHorScrView a;
  protected CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  protected List<bbje>[] a;
  public int b;
  protected GridView b;
  public TextView b;
  public ElasticHorScrView b;
  protected boolean b;
  protected int c;
  private boolean c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public bbjc(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public bbjc(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, 1);
  }
  
  public bbjc(Context paramContext, boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramInt == 2)
    {
      bcvg localbcvg = new bcvg();
      localbcvg.jdField_a_of_type_AndroidContentContext = paramContext;
      localbcvg.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Bcuq = bcus.a(localbcvg);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bfol = ((bfol)bfoy.b(this.jdField_a_of_type_AndroidContentContext, null));
      paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_c_of_type_Int = paramContext.getDimensionPixelSize(2131296669);
      this.e = this.jdField_c_of_type_Int;
      this.f = paramContext.getDimensionPixelOffset(2131296671);
      this.g = paramContext.getDimensionPixelOffset(2131296672);
      this.jdField_a_of_type_Bbji = new bbji();
      paramInt = paramContext.getDisplayMetrics().widthPixels;
      int i = paramContext.getDisplayMetrics().heightPixels;
      if (paramInt <= i) {
        break label209;
      }
      paramInt = i;
    }
    label209:
    for (;;)
    {
      paramInt = (paramInt - (int)(a() * 5.2F)) / (((int)5.2F + 1) * 2);
      c(paramInt);
      b((int)(paramInt * 6 / 5.5F));
      return;
      this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null));
      break;
    }
  }
  
  private static int a(TextPaint paramTextPaint, String paramString, float paramFloat)
  {
    int j;
    if (paramTextPaint.measureText(paramString) < paramFloat)
    {
      j = paramString.length();
      return j;
    }
    int i = 1;
    for (;;)
    {
      if (i > paramString.length()) {
        break label54;
      }
      j = i;
      if (paramTextPaint.measureText(paramString.substring(0, i)) > paramFloat) {
        break;
      }
      i += 1;
    }
    label54:
    return paramString.length();
  }
  
  protected static String a(TextPaint paramTextPaint, float paramFloat, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    String str;
    do
    {
      do
      {
        return paramString;
        i = a(paramTextPaint, paramString, paramFloat);
        if (!ajzv.a()) {
          break;
        }
        paramInt = Math.min(paramInt, i);
      } while (paramString.length() <= paramInt);
      str = paramString.substring(0, paramInt);
      paramString = paramString.substring(paramInt);
      paramInt = a(paramTextPaint, paramString, paramFloat);
      paramTextPaint = paramString;
      if (paramString.length() > paramInt) {
        paramTextPaint = paramString.substring(0, paramInt) + "..";
      }
      return str + "\n" + paramTextPaint;
    } while (paramString.length() <= i);
    paramTextPaint = new StringBuilder();
    paramString = paramString.split(" ");
    int j = paramString.length;
    paramInt = 0;
    for (;;)
    {
      int k;
      if (paramInt < j)
      {
        str = paramString[paramInt];
        k = paramTextPaint.toString().length() + str.length();
        if (k <= i * 2) {}
      }
      else
      {
        paramString = paramTextPaint.toString().trim();
        paramTextPaint = paramString;
        if (paramString.length() > i * 2) {
          paramTextPaint = paramString.substring(0, i) + "..";
        }
        return paramTextPaint;
      }
      if ((!paramTextPaint.toString().contains("\n")) && (k > i)) {
        paramTextPaint.append("\n");
      }
      paramTextPaint.append(str).append(" ");
      paramInt += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      return this.jdField_a_of_type_Bcuq.a();
    }
    return this.jdField_c_of_type_Int;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558829, null);
    this.jdField_a_of_type_Bbji.a((RelativeLayout)localView.findViewById(2131362137));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131361921));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361919));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375662));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375663));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label406;
      }
      localObject1 = localObject2[0];
      label136:
      if (!((List)localObject1).isEmpty()) {
        break label969;
      }
    }
    label161:
    label958:
    label961:
    label964:
    label969:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label964;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298815));
        Object localObject4 = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject1), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        StaticLayout localStaticLayout = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject2), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296668);
        int i;
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367168));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label366:
          if (((Iterator)localObject4).hasNext())
          {
            if (((bbje)((Iterator)localObject4).next()).d != 0) {
              break label961;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label366;
          f();
          break;
          localObject1 = new ArrayList(0);
          break label136;
          localObject2 = new ArrayList(0);
          break label161;
          int n = this.d + a() + this.d;
          this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(n);
          this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
          localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
          this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.h + this.h);
          this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
          this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(a(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
          this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          if (k != 0)
          {
            this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367169));
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((bbje)((Iterator)localObject1).next()).d != 0) {
                break label958;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.d + a() + this.d;
            this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(n);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
            this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.h + this.h);
            this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
            this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(a(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
            this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
            this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361912));
            this.jdField_b_of_type_AndroidWidgetTextView.setText(2131692904);
            this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bbjd(this));
            if (j == 0) {
              this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            if (k == 0) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            localView.post(new ShareActionSheetBuilder.2(this));
            return localView;
          }
        }
      }
    }
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      return this.jdField_a_of_type_Bcuq.a(paramInt);
    }
    Window localWindow = this.jdField_a_of_type_Bfol.getWindow();
    if (localWindow != null) {
      return localWindow.findViewById(paramInt);
    }
    return null;
  }
  
  public Window a()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      return this.jdField_a_of_type_Bcuq.a();
    }
    return this.jdField_a_of_type_Bfol.getWindow();
  }
  
  protected bbjf a(Context paramContext, List<bbje> paramList)
  {
    return new bbjf(paramContext, paramList);
  }
  
  public bfol a()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      return this.jdField_a_of_type_Bcuq.a();
    }
    return this.jdField_a_of_type_Bfol;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      return this.jdField_a_of_type_Bcuq.a();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(List<bbje> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((bbje)paramList.get(i)).jdField_a_of_type_JavaLangString;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a();
    }
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_AndroidViewView = a();
        }
        this.jdField_a_of_type_Bfol.a(this.jdField_a_of_type_AndroidViewView, null);
        try
        {
          if (!a())
          {
            if (this.jdField_c_of_type_Boolean) {
              wsu.b(a());
            }
            this.jdField_a_of_type_Bfol.show();
            if (this.jdField_c_of_type_Boolean)
            {
              wsu.a(a());
              wsu.c(a());
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShareActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(paramOnCancelListener);
      return;
    }
    this.jdField_a_of_type_Bfol.setOnCancelListener(paramOnCancelListener);
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a(paramOnDismissListener);
    }
    while (this.jdField_a_of_type_Bfol == null) {
      return;
    }
    this.jdField_a_of_type_Bfol.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(DialogInterface.OnShowListener paramOnShowListener)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(paramOnShowListener);
      return;
    }
    this.jdField_a_of_type_Bfol.setOnShowListener(paramOnShowListener);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a(paramIntent);
    }
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(paramView, paramLayoutParams);
      return;
    }
    this.jdField_a_of_type_Bbji.a(paramView, paramLayoutParams);
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a(paramOnItemClickListener);
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
        this.jdField_a_of_type_Boolean = true;
      } while (paramOnItemClickListener != null);
      if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
      }
    } while (this.jdField_b_of_type_AndroidWidgetGridView == null);
    this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(null);
  }
  
  public void a(bcur parambcur)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a(parambcur);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.a(paramCharSequence);
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(paramString);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<bbje> paramList1, List<bbje> paramList2) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(paramBoolean);
      return;
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(List<bbje>[] paramArrayOfList)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.a(paramArrayOfList);
      return;
    }
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      return this.jdField_a_of_type_Bcuq.a();
    }
    return this.jdField_a_of_type_Bfol.isShowing();
  }
  
  protected List<bbje>[] a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaUtilList != null) {
      return this.jdField_a_of_type_ArrayOfJavaUtilList;
    }
    return (List[])new ArrayList[0];
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.b();
    }
    do
    {
      return;
      a(null);
    } while (!a());
    try
    {
      this.jdField_a_of_type_Bfol.dismiss();
      this.jdField_a_of_type_AndroidViewView = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("ShareActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.b(paramInt);
      return;
    }
    this.h = paramInt;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.c();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.c(paramInt);
      return;
    }
    this.d = paramInt;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.d();
    }
    while (!this.jdField_a_of_type_Bfol.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bfol.a(this.jdField_a_of_type_AndroidViewView, null);
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_Bcuq != null)
    {
      this.jdField_a_of_type_Bcuq.d(paramInt);
      return;
    }
    this.jdField_a_of_type_Bbji.a(paramInt);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.e();
    }
    while (!this.jdField_a_of_type_Bfol.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_Bfol.a(this.jdField_a_of_type_AndroidViewView, null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.f();
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
    } while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bcuq != null) {
      this.jdField_a_of_type_Bcuq.g();
    }
    int i;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - this.h;
    } while ((this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView == null) || (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView == null));
    if (i < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (i < this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjc
 * JD-Core Version:    0.7.0.1
 */