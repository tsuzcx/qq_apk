import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class anpo
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<ApolloActionPackage> jdField_a_of_type_JavaUtilList;
  private int b = -1;
  
  public anpo(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_Int = paramContext.getResources().getColor(2131165635);
  }
  
  public Drawable a(ApolloActionPackage paramApolloActionPackage)
  {
    ApolloActionPackage localApolloActionPackage = null;
    StateListDrawable localStateListDrawable = new StateListDrawable();
    URLDrawable localURLDrawable2;
    if (!TextUtils.isEmpty(paramApolloActionPackage.mIconSelectedUrl))
    {
      localURLDrawable2 = anev.a("" + paramApolloActionPackage.mIconSelectedUrl.hashCode(), null, paramApolloActionPackage.mIconSelectedUrl, true);
      localURLDrawable1 = localURLDrawable2;
      if (localURLDrawable2 != null) {
        localURLDrawable2.startDownload();
      }
    }
    for (URLDrawable localURLDrawable1 = localURLDrawable2;; localURLDrawable1 = null)
    {
      if (!TextUtils.isEmpty(paramApolloActionPackage.mIconUnselectedUrl))
      {
        paramApolloActionPackage = anev.a("" + paramApolloActionPackage.mIconUnselectedUrl.hashCode(), null, paramApolloActionPackage.mIconUnselectedUrl, true);
        localApolloActionPackage = paramApolloActionPackage;
        if (paramApolloActionPackage != null)
        {
          paramApolloActionPackage.startDownload();
          localApolloActionPackage = paramApolloActionPackage;
        }
      }
      if (localURLDrawable1 != null) {
        localStateListDrawable.addState(new int[] { 16842913 }, localURLDrawable1);
      }
      if (localApolloActionPackage != null) {
        localStateListDrawable.addState(new int[] { -16842913 }, localApolloActionPackage);
      }
      return localStateListDrawable;
    }
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (ApolloActionPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<ApolloActionPackage> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(14)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558703, paramViewGroup, false);
      paramView = new anpp();
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131378394));
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setActivated(true);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setEnabled(true);
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131378391);
      paramView.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Int);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131378392));
      paramView.b = localView.findViewById(2131381137);
      localView.setTag(paramView);
      localObject = paramView.b;
      if (paramInt != 0) {
        break label278;
      }
      i = 0;
      label129:
      ((View)localObject).setVisibility(i);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = a(paramInt);
      if (localObject != null)
      {
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(a((ApolloActionPackage)localObject));
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(((ApolloActionPackage)localObject).name);
        if (((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime)) || ((((ApolloActionPackage)localObject).packageId == 8) && (!((ApolloActionPackage)localObject).isRecommendTabClick))) {
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      if (paramInt != this.b) {
        break label285;
      }
      localView.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (anpp)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label278:
      i = 8;
      break label129;
      label285:
      localView.setSelected(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpo
 * JD-Core Version:    0.7.0.1
 */