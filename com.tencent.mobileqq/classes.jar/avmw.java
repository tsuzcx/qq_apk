import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;

public class avmw
  extends blir
  implements bljm
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aoof jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_AndroidContentContext, anbd.a());
  private avmy jdField_a_of_type_Avmy;
  private bhzs jdField_a_of_type_Bhzs = new avmx(this);
  private String jdField_a_of_type_JavaLangString;
  private List<FeedsItemData.FriendInfo> jdField_a_of_type_JavaUtilList;
  
  protected avmw(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public avmw(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    f();
    anbd.a().addObserver(this.jdField_a_of_type_Bhzs);
    ((VasExtensionHandler)anbd.a().getBusinessHandler(71)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  private String a(long paramLong)
  {
    paramLong = System.currentTimeMillis() / 1000L - paramLong;
    if (paramLong < 60L) {
      return paramLong / 60L + anzj.a(2131709166);
    }
    if ((paramLong >= 60L) && (paramLong < 3600L)) {
      return paramLong / 60L + anzj.a(2131709169);
    }
    if ((paramLong >= 3600L) && (paramLong < paramLong / 86400L)) {
      return paramLong / 3600L + anzj.a(2131709167);
    }
    int i = (int)(paramLong / 86400L);
    if (i >= 30) {
      return i / 30 + anzj.a(2131709172);
    }
    if (i >= 7) {
      return i / 7 + anzj.a(2131709170);
    }
    return i + anzj.a(2131709171);
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, agej.a(500.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_popView_card@2x.png"));
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setId(2131367369);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, (int)(bhlo.k() / 750L * 36L));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).setBackgroundColor(-1);
    localLayoutParams1.addRule(3, ((ImageView)localObject2).getId());
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setText(anzj.a(2131709168));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    ((TextView)localObject2).setTextSize(18.0F);
    ((TextView)localObject2).setTextColor(-16777216);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367371);
    localObject3 = new ListView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Avmy = new avmy(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList);
    ((ListView)localObject3).setAdapter(this.jdField_a_of_type_Avmy);
    ((ListView)localObject3).setOnItemClickListener(this);
    ((ListView)localObject3).setBackgroundColor(-1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, ((TextView)localObject2).getId());
    ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams2);
    localRelativeLayout.addView((View)localObject1, localLayoutParams1);
    ((ListView)localObject3).setDividerHeight(0);
    ((ListView)localObject3).setSelector(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850680));
    a(localRelativeLayout, localLayoutParams);
  }
  
  public void dismiss()
  {
    super.dismiss();
    anbd.a().removeObserver(this.jdField_a_of_type_Bhzs);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (anyw)anbd.a().getManager(51);
    paramView = (FeedsItemData.FriendInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (TextUtils.isEmpty(paramView.jumpUrl))
    {
      if (paramAdapterView.b(paramView.uin)) {
        paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 1);
      }
      for (paramAdapterView.jdField_h_of_type_JavaLangString = paramView.name;; paramAdapterView.jdField_h_of_type_JavaLangString = paramView.name)
      {
        paramAdapterView.f = paramView.uin;
        paramAdapterView.e = 3000;
        paramAdapterView.g = 2;
        paramAdapterView.jdField_h_of_type_Int = 106;
        ProfileActivity.b(getContext(), paramAdapterView);
        return;
        paramAdapterView = new ProfileActivity.AllInOne(paramView.uin, 19);
      }
    }
    paramAdapterView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramAdapterView.putExtra("url", paramView.jumpUrl);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmw
 * JD-Core Version:    0.7.0.1
 */