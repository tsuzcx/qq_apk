import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FavoriteSearchFragment;

public class bivw
  extends ayjo<aynu, aywd>
  implements View.OnClickListener
{
  public bivw(FavoriteSearchFragment paramFavoriteSearchFragment, ListView paramListView, bdbb parambdbb)
  {
    super(paramListView, parambdbb);
  }
  
  protected ayqp<aynu, aywd> a(int paramInt)
  {
    return new biwa(FavoriteSearchFragment.a(this.a));
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ayxt(paramViewGroup, 2131562605);
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if ((i > 0) && (((bivz)super.a(i - 1)).a == -2L)) {
      return i - 1;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == super.getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      Object localObject;
      if (paramView == null)
      {
        localObject = new TextView(paramViewGroup.getContext());
        ((TextView)localObject).setTextSize(18.0F);
        ((TextView)localObject).setTextColor(paramViewGroup.getResources().getColor(2131166914));
        ((TextView)localObject).setGravity(1);
        ((TextView)localObject).setClickable(true);
        ((TextView)localObject).setOnClickListener(this);
        ((TextView)localObject).setPadding(0, 16, 0, 16);
        paramView = (View)localObject;
        paramViewGroup = paramView;
        if (((bivz)super.a(paramInt)).a != -1L) {
          break label118;
        }
        paramViewGroup.performClick();
      }
      label118:
      do
      {
        return localObject;
        paramViewGroup = (TextView)paramView;
        localObject = paramView;
        break;
        paramViewGroup.setText(2131698441);
        paramView = (Animatable)paramViewGroup.getCompoundDrawables()[1];
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      } while (paramView == null);
      paramView.stop();
      return localObject;
    }
    return super.getView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView;
    paramView.setText(null);
    Animatable localAnimatable = (Animatable)BaseApplicationImpl.sApplication.getResources().getDrawable(2130839225);
    paramView.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localAnimatable, null, null);
    localAnimatable.start();
    paramView = (FavoriteSearchEngine)this.a.a;
    FavoriteSearchFragment.a(this.a).a = this.a.c;
    paramView.a(FavoriteSearchFragment.a(this.a), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivw
 * JD-Core Version:    0.7.0.1
 */