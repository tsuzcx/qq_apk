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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bctw
  extends bjuw
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List<bcty> jdField_a_of_type_JavaUtilList;
  Map<String, bcty> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public bctw(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<bcty> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public String a(String paramString)
  {
    Object localObject = (bcty)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = ContactUtils.getTeamworkAuthorzShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bcty)localObject).jdField_a_of_type_JavaLangString, ((bcty)localObject).b, ((bcty)localObject).jdField_a_of_type_Int);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((bcty)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = ((String)localObject);
    }
    return ((bcty)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bcty parambcty)
  {
    if (parambcty == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(0, parambcty);
    this.jdField_a_of_type_JavaUtilMap.put(parambcty.jdField_a_of_type_JavaLangString, parambcty);
  }
  
  public void a(String paramString)
  {
    bcty localbcty = (bcty)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localbcty == null) {
      return;
    }
    localbcty.c = a(paramString);
    notifyDataSetChanged();
  }
  
  public void b(String paramString)
  {
    paramString = (bcty)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
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
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562863, null);
      paramView = new bctx(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368030));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371769));
      paramView.b = ((TextView)localView.findViewById(2131377734));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362983));
      localView.setTag(paramView);
      if (this.jdField_a_of_type_Int != 2) {
        break label262;
      }
      paramView.b.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = (bcty)getItem(paramInt);
      String str = String.valueOf(((bcty)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint64_uin.get());
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localFaceDrawable);
      str = a(str);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      i = ((bcty)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo.uint32_right.get();
      if (i != 1) {
        break label281;
      }
      paramView.b.setText(2131718830);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = ((bcty)localObject).jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo;
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bctx)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label262:
      paramView.b.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break label116;
      label281:
      if (i == 2) {
        paramView.b.setText(2131718831);
      } else {
        paramView.b.setText(amtj.a(2131713814));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctw
 * JD-Core Version:    0.7.0.1
 */