import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ayrz
  extends BaseAdapter
  implements aoog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ayqv jdField_a_of_type_Ayqv;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private List<aysk> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ayrz(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Ayqv = new ayqv(paramQQAppInterface, paramContext);
    }
  }
  
  public List<aysk> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List<aysk> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<aysk> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_Ayqv == null) {
      return -1;
    }
    return this.jdField_a_of_type_Ayqv.a((aysk)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (this.jdField_a_of_type_Ayqv == null) {
      localView = null;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      aysk localaysk = (aysk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      int i = this.jdField_a_of_type_Ayqv.a(localaysk);
      ayqg localayqg = this.jdField_a_of_type_Ayqv.a(i);
      localView = paramView;
      if (localayqg != null)
      {
        localayqg.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
        localView = localayqg.a(localaysk, this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      paramView = localView;
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Ayqv == null) {
      return 1;
    }
    return this.jdField_a_of_type_Ayqv.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin)) {
      return;
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrz
 * JD-Core Version:    0.7.0.1
 */