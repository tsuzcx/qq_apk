import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.util.ArrayList;
import java.util.List;

class asob
  extends BaseAdapter
{
  public Context a;
  public List<FeedsItemData.FriendInfo> a;
  
  public asob(Context paramContext, List<FeedsItemData.FriendInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramList;
    List localList;
    a(localList);
  }
  
  public void a(List<FeedsItemData.FriendInfo> paramList)
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
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = (FeedsItemData.FriendInfo)asnz.a(this.jdField_a_of_type_Asnz).get(paramInt);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    CornerImageView localCornerImageView = new CornerImageView(this.jdField_a_of_type_AndroidContentContext);
    localCornerImageView.setId(2131367042);
    Object localObject2 = ((FeedsItemData.FriendInfo)localObject1).uin;
    localCornerImageView.setRadius(aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) / 2);
    paramViewGroup = asnz.a(this.jdField_a_of_type_Asnz).a(1, (String)localObject2);
    paramView = paramViewGroup;
    if (paramViewGroup == null)
    {
      paramView = bdhj.a();
      asnz.a(this.jdField_a_of_type_Asnz).a((String)localObject2, 1, false);
    }
    localCornerImageView.setImageBitmap(paramView);
    paramView = new RelativeLayout.LayoutParams(aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramView.addRule(9);
    paramView.setMargins(aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, aepi.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, localCornerImageView.getId());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = aepi.a(80.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Object localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setText(((FeedsItemData.FriendInfo)localObject1).name);
    ((TextView)localObject3).setTextSize(16.0F);
    ((TextView)localObject3).setTextColor(-16777216);
    ((TextView)localObject3).setMaxLines(1);
    ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject3).setId(2131370977);
    ((TextView)localObject3).setMaxWidth(aepi.a(110.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramViewGroup.addView((View)localObject3);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-2145246686);
    if (((FeedsItemData.FriendInfo)localObject1).loginTime < 0L)
    {
      localTextView.setVisibility(4);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, ((TextView)localObject3).getId());
      localLayoutParams.addRule(8, ((TextView)localObject3).getId());
      localLayoutParams.leftMargin = aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.bottomMargin = aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.addView(localTextView, localLayoutParams);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setTextSize(10.0F);
      localTextView.setTextColor(-6579301);
      if ((!TextUtils.isEmpty(((FeedsItemData.FriendInfo)localObject1).partition)) || (!TextUtils.isEmpty(((FeedsItemData.FriendInfo)localObject1).roleName))) {
        break label829;
      }
      localTextView.setText(alud.a(2131710688));
    }
    for (;;)
    {
      localTextView.setBackgroundColor(1270796256);
      localTextView.setPadding(aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((TextView)localObject3).getId());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewGroup.addView(localTextView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setText(alud.a(2131710689));
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(16.0F);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setBackgroundDrawable(asnl.a(new ColorDrawable(-16776961), new ColorDrawable(-16776961), "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png"));
      localObject3 = new RelativeLayout.LayoutParams(aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localRelativeLayout.addView(localCornerImageView, paramView);
      localRelativeLayout.addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      return localRelativeLayout;
      localTextView.setText(asnz.a(this.jdField_a_of_type_Asnz, ((FeedsItemData.FriendInfo)localObject1).loginTime));
      break;
      label829:
      localTextView.setText(((FeedsItemData.FriendInfo)localObject1).partition + " " + ((FeedsItemData.FriendInfo)localObject1).roleName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asob
 * JD-Core Version:    0.7.0.1
 */