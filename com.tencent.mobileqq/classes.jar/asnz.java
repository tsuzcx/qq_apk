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
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import java.util.List;

public class asnz
  extends bhuf
  implements bhuw
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private asob jdField_a_of_type_Asob;
  private bdbb jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_AndroidContentContext, akwd.a());
  private bdul jdField_a_of_type_Bdul = new asoa(this);
  private String jdField_a_of_type_JavaLangString;
  private List<FeedsItemData.FriendInfo> jdField_a_of_type_JavaUtilList;
  
  protected asnz(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public asnz(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    f();
    akwd.a().addObserver(this.jdField_a_of_type_Bdul);
    ((bdug)akwd.a().getBusinessHandler(71)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  private String a(long paramLong)
  {
    paramLong = System.currentTimeMillis() / 1000L - paramLong;
    if (paramLong < 60L) {
      return paramLong / 60L + alud.a(2131710681);
    }
    if ((paramLong >= 60L) && (paramLong < 3600L)) {
      return paramLong / 60L + alud.a(2131710684);
    }
    if ((paramLong >= 3600L) && (paramLong < paramLong / 86400L)) {
      return paramLong / 3600L + alud.a(2131710682);
    }
    int i = (int)(paramLong / 86400L);
    if (i >= 30) {
      return i / 30 + alud.a(2131710687);
    }
    if (i >= 7) {
      return i / 7 + alud.a(2131710685);
    }
    return i + alud.a(2131710686);
  }
  
  private void f()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, aepi.a(500.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_popView_card@2x.png"));
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject2).setId(2131367041);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, (int)(bdgk.k() / 750L * 36L));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).setBackgroundColor(-1);
    localLayoutParams1.addRule(3, ((ImageView)localObject2).getId());
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setText(alud.a(2131710683));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    ((TextView)localObject2).setTextSize(18.0F);
    ((TextView)localObject2).setTextColor(-16777216);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    ((TextView)localObject2).setId(2131367043);
    localObject3 = new ListView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Asob = new asob(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList);
    ((ListView)localObject3).setAdapter(this.jdField_a_of_type_Asob);
    ((ListView)localObject3).setOnItemClickListener(this);
    ((ListView)localObject3).setBackgroundColor(-1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(3, ((TextView)localObject2).getId());
    ((RelativeLayout)localObject1).addView((View)localObject3, localLayoutParams2);
    localRelativeLayout.addView((View)localObject1, localLayoutParams1);
    ((ListView)localObject3).setDividerHeight(0);
    ((ListView)localObject3).setSelector(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850072));
    a(localRelativeLayout, localLayoutParams);
  }
  
  public void dismiss()
  {
    super.dismiss();
    akwd.a().removeObserver(this.jdField_a_of_type_Bdul);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (alto)akwd.a().getManager(51);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnz
 * JD-Core Version:    0.7.0.1
 */