import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FavoriteSearchFragment;

public class bmlk
  extends bcbj<bcfr, bcnz>
  implements View.OnClickListener
{
  public bmlk(FavoriteSearchFragment paramFavoriteSearchFragment, ListView paramListView, aoof paramaoof)
  {
    super(paramListView, paramaoof);
  }
  
  protected bcil<bcfr, bcnz> a(int paramInt)
  {
    return new bmlo(FavoriteSearchFragment.a(this.a));
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    return new bcpp(paramViewGroup, 2131562877);
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if ((i > 0) && (((bmln)super.a(i - 1)).a == -2L)) {
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
    Object localObject1;
    if (getItemViewType(paramInt) == 1) {
      if (paramView == null)
      {
        paramView = new TextView(paramViewGroup.getContext());
        paramView.setTextSize(18.0F);
        paramView.setTextColor(paramViewGroup.getResources().getColor(2131167001));
        paramView.setGravity(1);
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
        paramView.setPadding(0, 16, 0, 16);
        localObject1 = paramView;
        if (((bmln)super.a(paramInt)).a != -1L) {
          break label125;
        }
        ((TextView)localObject1).performClick();
        label96:
        localObject1 = paramView;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (TextView)paramView;
      break;
      label125:
      ((TextView)localObject1).setText(2131697411);
      Object localObject2 = (Animatable)localObject1.getCompoundDrawables()[1];
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if (localObject2 == null) {
        break label96;
      }
      ((Animatable)localObject2).stop();
      break label96;
      localObject2 = super.getView(paramInt, paramView, paramViewGroup);
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView;
    ((TextView)localObject).setText(null);
    Animatable localAnimatable = (Animatable)BaseApplicationImpl.sApplication.getResources().getDrawable(2130839410);
    ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localAnimatable, null, null);
    localAnimatable.start();
    localObject = (FavoriteSearchEngine)this.a.a;
    FavoriteSearchFragment.a(this.a).a = this.a.c;
    ((FavoriteSearchEngine)localObject).a(FavoriteSearchFragment.a(this.a), this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlk
 * JD-Core Version:    0.7.0.1
 */