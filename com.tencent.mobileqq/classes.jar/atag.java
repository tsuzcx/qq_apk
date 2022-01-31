import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import java.util.ArrayList;
import java.util.List;

public class atag
  extends BaseAdapter
  implements azwh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private aszc jdField_a_of_type_Aszc;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private List<atar> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public atag(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Aszc = new aszc(paramQQAppInterface, paramContext);
    }
  }
  
  public List<atar> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List<atar> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<atar> paramList)
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
    if (this.jdField_a_of_type_Aszc == null) {
      return -1;
    }
    return this.jdField_a_of_type_Aszc.a((atar)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aszc == null) {
      paramViewGroup = null;
    }
    atar localatar;
    asyn localasyn;
    do
    {
      return paramViewGroup;
      localatar = (atar)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramInt = this.jdField_a_of_type_Aszc.a(localatar);
      localasyn = this.jdField_a_of_type_Aszc.a(paramInt);
      paramViewGroup = paramView;
    } while (localasyn == null);
    localasyn.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    return localasyn.a(localatar, this.jdField_a_of_type_AndroidContentContext, paramView);
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Aszc == null) {
      return 1;
    }
    return this.jdField_a_of_type_Aszc.a();
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
 * Qualified Name:     atag
 * JD-Core Version:    0.7.0.1
 */