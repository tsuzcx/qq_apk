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

public class atwm
  extends BaseAdapter
  implements baxz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private atvi jdField_a_of_type_Atvi;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private List<atwx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public atwm(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Atvi = new atvi(paramQQAppInterface, paramContext);
    }
  }
  
  public List<atwx> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
  }
  
  public void a(List<atwx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<atwx> paramList)
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
    if (this.jdField_a_of_type_Atvi == null) {
      return -1;
    }
    return this.jdField_a_of_type_Atvi.a((atwx)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Atvi == null) {
      paramViewGroup = null;
    }
    atwx localatwx;
    atut localatut;
    do
    {
      return paramViewGroup;
      localatwx = (atwx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramInt = this.jdField_a_of_type_Atvi.a(localatwx);
      localatut = this.jdField_a_of_type_Atvi.a(paramInt);
      paramViewGroup = paramView;
    } while (localatut == null);
    localatut.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
    return localatut.a(localatwx, this.jdField_a_of_type_AndroidContentContext, paramView);
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Atvi == null) {
      return 1;
    }
    return this.jdField_a_of_type_Atvi.a();
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
 * Qualified Name:     atwm
 * JD-Core Version:    0.7.0.1
 */