import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class beaf
  extends blqv
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<beah> jdField_a_of_type_JavaUtilList;
  Map<String, beah> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public beaf(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<beah> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public String a(String paramString)
  {
    Object localObject = (beah)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((beah)localObject).jdField_a_of_type_JavaLangString, ((beah)localObject).b, ((beah)localObject).jdField_a_of_type_Int);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((beah)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = ((String)localObject);
    }
    return ((beah)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(beah parambeah)
  {
    if (parambeah == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, parambeah);
    this.jdField_a_of_type_JavaUtilMap.put(parambeah.jdField_a_of_type_JavaLangString, parambeah);
  }
  
  public void a(String paramString)
  {
    beah localbeah = (beah)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbeah == null) {
      return;
    }
    localbeah.c = a(paramString);
    notifyDataSetChanged();
  }
  
  public void b(String paramString)
  {
    paramString = (beah)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
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
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    label116:
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562984, null);
      paramView = new beag(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367997));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371805));
      paramView.b = ((TextView)localView.findViewById(2131377965));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362969));
      localView.setTag(paramView);
      if (this.jdField_a_of_type_Int != 2) {
        break label262;
      }
      paramView.b.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = (beah)getItem(paramInt);
      String str = String.valueOf(((beah)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get());
      aoot localaoot = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localaoot);
      str = a(str);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      i = ((beah)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.get();
      if (i != 1) {
        break label281;
      }
      paramView.b.setText(2131718582);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = ((beah)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo;
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (beag)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label262:
      paramView.b.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label116;
      label281:
      if (i == 2) {
        paramView.b.setText(2131718583);
      } else {
        paramView.b.setText(anzj.a(2131713582));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beaf
 * JD-Core Version:    0.7.0.1
 */