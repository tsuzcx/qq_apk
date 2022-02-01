import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet.2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbjd
{
  public int a;
  protected Context a;
  protected View a;
  protected AdapterView.OnItemClickListener a;
  protected TextView a;
  protected bbjh a;
  protected final blir a;
  public ElasticHorScrView a;
  protected CharSequence a;
  protected boolean a;
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a;
  protected int b;
  public ElasticHorScrView b;
  private boolean b;
  protected int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public bbjd(Context paramContext)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blir = ((blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null));
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.e = paramContext.getDimensionPixelSize(2131296740);
    this.f = this.e;
    this.g = paramContext.getDimensionPixelOffset(2131296742);
    this.h = paramContext.getDimensionPixelOffset(2131296743);
    this.jdField_a_of_type_Bbjh = new bbjh();
    int i = (paramContext.getDisplayMetrics().widthPixels - (int)(a() * 5.2F)) / (((int)5.2F + 1) * 2);
    b(i);
    a((int)(i * 6 / 5.5F));
  }
  
  private String a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label54;
      }
      localObject = str;
    }
    label54:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  private static String b(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  public int a()
  {
    return this.e;
  }
  
  @TargetApi(9)
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558936, null);
    this.jdField_a_of_type_Bbjh.a((RelativeLayout)localView.findViewById(2131362216));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361975));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377120));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131377121));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label376;
      }
      localObject1 = localObject2[0];
      label122:
      if (!((List)localObject1).isEmpty()) {
        break label893;
      }
    }
    label147:
    label336:
    label376:
    label888:
    label893:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label888;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298939));
        Object localObject4 = new StaticLayout(b(a((List)localObject1), 6), (TextPaint)localObject3, this.f, Layout.Alignment.ALIGN_CENTER, 1.0F, this.h, true);
        Object localObject5 = new StaticLayout(b(a((List)localObject2), 6), (TextPaint)localObject3, this.f, Layout.Alignment.ALIGN_CENTER, 1.0F, this.h, true);
        localObject3 = localObject5;
        if (((StaticLayout)localObject4).getHeight() >= ((StaticLayout)localObject5).getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296739);
        int i;
        if (j != 0)
        {
          localObject4 = (GridView)localView.findViewById(2131367683);
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject5 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject5).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject5).next()).visibility != 0) {
              break label885;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label336;
          b();
          break;
          localObject1 = new ArrayList(0);
          break label122;
          localObject2 = new ArrayList(0);
          break label147;
          int n = this.jdField_b_of_type_Int + a() + this.jdField_b_of_type_Int;
          ((GridView)localObject4).setColumnWidth(n);
          ((GridView)localObject4).setNumColumns(i);
          localObject5 = ((GridView)localObject4).getLayoutParams();
          ((GridView)localObject4).setPadding(this.c, ((GridView)localObject4).getPaddingTop(), this.c, ((GridView)localObject4).getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject5).width = (n * i + this.c + this.c);
          this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject5).width;
          ((ViewGroup.LayoutParams)localObject5).height = (this.e + this.g + ((StaticLayout)localObject3).getHeight() + m);
          ((GridView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((GridView)localObject4).setAdapter(new bbjf(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
          ((GridView)localObject4).setSelector(new ColorDrawable(0));
          ((GridView)localObject4).setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          if (k != 0)
          {
            localObject1 = (GridView)localView.findViewById(2131367684);
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            ((GridView)localObject1).setSmoothScrollbarEnabled(false);
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject4).hasNext())
            {
              if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
                break label882;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.jdField_b_of_type_Int + a() + this.jdField_b_of_type_Int;
            ((GridView)localObject1).setColumnWidth(n);
            ((GridView)localObject1).setNumColumns(i);
            localObject4 = ((GridView)localObject1).getLayoutParams();
            ((GridView)localObject1).setPadding(this.c, ((GridView)localObject1).getPaddingTop(), this.c, ((GridView)localObject1).getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.c + this.c);
            this.d = ((ViewGroup.LayoutParams)localObject4).width;
            ((ViewGroup.LayoutParams)localObject4).height = (this.e + this.g + ((StaticLayout)localObject3).getHeight() + m);
            ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((GridView)localObject1).setNumColumns(i);
            ((GridView)localObject1).setAdapter(new bbjf(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
            ((GridView)localObject1).setSelector(new ColorDrawable(0));
            ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
            localObject1 = (TextView)localView.findViewById(2131361967);
            ((TextView)localObject1).setText(2131690580);
            ((TextView)localObject1).setOnClickListener(new bbje(this));
            if (j == 0) {
              this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            if (k == 0) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            localView.post(new ShareActionSheet.2(this));
            return localView;
          }
        }
      }
    }
  }
  
  public blir a()
  {
    return this.jdField_a_of_type_Blir;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidViewView = a();
    }
    this.jdField_a_of_type_Blir.a(this.jdField_a_of_type_AndroidViewView, null);
    try
    {
      if (!a()) {
        this.jdField_a_of_type_Blir.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
  }
  
  public void a(List<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfList)
  {
    this.jdField_a_of_type_ArrayOfJavaUtilList = paramArrayOfList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Blir.isShowing();
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaUtilList != null) {
      return this.jdField_a_of_type_ArrayOfJavaUtilList;
    }
    return (List[])new ArrayList[0];
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjd
 * JD-Core Version:    0.7.0.1
 */