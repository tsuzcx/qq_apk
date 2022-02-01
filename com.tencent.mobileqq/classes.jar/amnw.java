import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class amnw
  extends amnh
  implements bbzm, blih
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_b_of_type_Boolean;
  
  public amnw(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List<bbzf> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTextView.getContext().getResources().getDrawable(2130841751);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      ThemeUtil.setThemeFilter(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
      paramTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a()
  {
    super.a();
  }
  
  protected boolean a(amni paramamni)
  {
    boolean bool2 = super.a(paramamni);
    boolean bool1 = bool2;
    if ((paramamni instanceof amnx))
    {
      paramamni = (amnx)paramamni;
      if ((bool2) && (!paramamni.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void c()
  {
    super.b();
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 5) {
      return 5;
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    amnx localamnx;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558959, paramViewGroup, false);
      localamnx = new amnx();
      localamnx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369247));
      localamnx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369391));
      localamnx.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369276));
      localamnx.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369220));
      localamnx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379958));
      localamnx.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376778);
      localamnx.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131701460));
      bbzx.a(localamnx.jdField_a_of_type_AndroidWidgetTextView);
      localamnx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379941));
      localamnx.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380171));
      localamnx.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369249));
      localamnx.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380059);
      paramView.setTag(localamnx);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (bbzf)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamnx = (amnx)paramView.getTag();
    }
    Object localObject2 = ((bbzf)localObject1).c();
    localamnx.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    if (String.valueOf(9954L).equals(((bbzf)localObject1).d())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(localamnx.jdField_a_of_type_AndroidWidgetTextView, bool1);
      localamnx.jdField_b_of_type_AndroidWidgetTextView.setText(((bbzf)localObject1).b());
      localamnx.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((bbzf)localObject1).b());
      if (((bbzf)localObject1).c() == 4) {
        bfmf.a(localamnx, ((bbzf)localObject1).d());
      }
      localamnx.jdField_c_of_type_AndroidWidgetTextView.setText(((bbzf)localObject1).a());
      localamnx.jdField_a_of_type_JavaLangString = ((bbzf)localObject1).d();
      localamnx.jdField_a_of_type_Int = ((bbzf)localObject1).c();
      if ((localObject1 instanceof bbya))
      {
        SearchHistory localSearchHistory = ((bbya)localObject1).a();
        bool1 = bool2;
        if (localSearchHistory.type != 56938)
        {
          if (localSearchHistory.type != 56942) {
            break label607;
          }
          bool1 = bool2;
        }
      }
      for (;;)
      {
        label414:
        localamnx.jdField_a_of_type_Boolean = bool1;
        if (localamnx.jdField_a_of_type_Boolean)
        {
          localamnx.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842062);
          localamnx.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          localamnx.jdField_d_of_type_AndroidWidgetTextView.setText(bhlg.a((String)localObject2));
          label462:
          localObject2 = ((bbzf)localObject1).a();
          if (localObject2 != null) {
            break label648;
          }
          localamnx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label484:
          if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
          {
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null)
          {
            localamnx.jdField_a_of_type_AndroidViewView.setTag(-1, Long.valueOf(((SearchHistory)((bbzf)localObject1).a()).getId()));
            localamnx.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          }
          localObject1 = paramView.findViewById(2131365649);
          if (paramInt != getCount() - 1) {
            break label670;
          }
          ((View)localObject1).setVisibility(8);
          label576:
          if (localamnx.jdField_b_of_type_AndroidViewView != null)
          {
            if (!bbzx.a(localamnx.jdField_a_of_type_JavaLangString)) {
              break label679;
            }
            localamnx.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          break;
          label607:
          bool1 = false;
          break label414;
          localamnx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(localamnx.jdField_a_of_type_JavaLangString, localamnx.jdField_a_of_type_Int));
          localamnx.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          break label462;
          label648:
          localamnx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localamnx.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          break label484;
          label670:
          ((View)localObject1).setVisibility(0);
          break label576;
          label679:
          localamnx.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnw
 * JD-Core Version:    0.7.0.1
 */