import EncounterSvc.RespEncounterInfo;
import EncounterSvc.RishState;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.1;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.2;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class atck
  implements View.OnClickListener, azwh
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  avev jdField_a_of_type_Avev;
  public azwg a;
  HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  HashMap<Long, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  int c = 0;
  
  public atck(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495321, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131306469));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311599));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_Avev = ((avev)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(15));
    paramContext = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("key_nearbyrecommender_title", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131628909));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    paramImageView.setVisibility(8);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131101320));
    VipOpenInfo localVipOpenInfo;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label84;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130849129);
      paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131101389));
    }
    label84:
    do
    {
      return;
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130849129);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131101389));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130849409);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131101389));
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    bboi localbboi = new bboi(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Avev.a(paramInt, 200), false, false);
    if (this.c == 0) {
      this.c = ((int)(paramSingleLineTextView.a() * 1.1F + 0.5F));
    }
    localbboi.setBounds(0, 0, this.c, this.c);
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(localbboi, null);
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, RespEncounterInfo paramRespEncounterInfo)
  {
    RichStatus localRichStatus;
    if (paramRespEncounterInfo.richState != null)
    {
      localRichStatus = RichStatus.parseStatus(paramRespEncounterInfo.richState.vState);
      localRichStatus.time = paramRespEncounterInfo.richState.uModifyTime;
    }
    for (paramRespEncounterInfo = localRichStatus;; paramRespEncounterInfo = null)
    {
      if ((paramRespEncounterInfo != null) && (!paramRespEncounterInfo.isEmpty()))
      {
        if (!TextUtils.isEmpty(paramRespEncounterInfo.actionText)) {
          a(paramSingleLineTextView, paramRespEncounterInfo.actionId);
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramRespEncounterInfo.actionId;
          paramSingleLineTextView.setText(paramRespEncounterInfo.toSpannableString(null));
          paramSingleLineTextView.setVisibility(0);
          return;
          paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
      }
      this.jdField_b_of_type_Int = 0;
      paramSingleLineTextView.setVisibility(8);
      return;
    }
  }
  
  public View a(RespEncounterInfo paramRespEncounterInfo)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493749, null);
    if ((localView != null) && (paramRespEncounterInfo != null))
    {
      localView.setTag(paramRespEncounterInfo);
      localView.setOnClickListener(this);
      a(localView, paramRespEncounterInfo);
    }
    return localView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo, ImageView paramImageView)
  {
    String str;
    Boolean localBoolean;
    try
    {
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        str = String.valueOf(paramRespEncounterInfo.tiny_id);
        if (this.jdField_a_of_type_Boolean)
        {
          localBoolean = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.tiny_id));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.tiny_id), Boolean.valueOf(true));
            ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.a(new ChatPushCarrierHelper.1(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_Azwg.a(32, str, 202);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_Azwg.a()) {
            this.jdField_a_of_type_Azwg.a(str, 202, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)bacm.a());
          }
          paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          return;
        }
        paramImageView.setImageBitmap(paramRespEncounterInfo);
        return;
      }
    }
    catch (Throwable paramRespEncounterInfo)
    {
      paramRespEncounterInfo.printStackTrace();
      return;
    }
    if (paramRespEncounterInfo.lEctID > 0L)
    {
      str = String.valueOf(paramRespEncounterInfo.lEctID);
      if (this.jdField_a_of_type_Boolean)
      {
        localBoolean = (Boolean)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramRespEncounterInfo.lEctID));
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(paramRespEncounterInfo.lEctID), Boolean.valueOf(true));
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.a(new ChatPushCarrierHelper.2(this, str, paramRespEncounterInfo));
        }
      }
      paramRespEncounterInfo = this.jdField_a_of_type_Azwg.a(32, str, 200);
      if (paramRespEncounterInfo == null)
      {
        this.jdField_a_of_type_Azwg.a(str, 200, true, false);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)bacm.a());
        }
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      paramImageView.setImageBitmap(paramRespEncounterInfo);
    }
  }
  
  public void a(View paramView, RespEncounterInfo paramRespEncounterInfo)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131302061);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131311221);
    Object localObject4 = (ImageView)paramView.findViewById(2131297338);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131302420);
    Object localObject1 = (TextView)paramView.findViewById(2131311285);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131313433);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131299391);
    Object localObject2 = (SingleLineTextView)paramView.findViewById(2131311479);
    Object localObject3 = paramView.findViewById(2131303037);
    TextView localTextView = (TextView)paramView.findViewById(2131305110);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131305764);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131298502);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131309994);
    View localView = paramView.findViewById(2131303103);
    paramView = (SingleLineTextView)paramView.findViewById(2131302552);
    this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101320);
    label222:
    int i;
    if (!TextUtils.isEmpty(paramRespEncounterInfo.strNick))
    {
      localSingleLineTextView1.setText(paramRespEncounterInfo.strNick.trim());
      if (paramRespEncounterInfo.authFlag != 1) {
        break label793;
      }
      ((ImageView)localObject4).setVisibility(0);
      ((TextView)localObject1).setVisibility(8);
      if (paramRespEncounterInfo.god_flag != 1) {
        break label860;
      }
      ((TextView)localObject1).setVisibility(0);
      localImageView5.setVisibility(0);
      if (paramRespEncounterInfo.cSex != 1) {
        break label803;
      }
      localImageView5.setBackgroundResource(2130844961);
      localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844594);
      ((TextView)localObject1).setBackgroundDrawable(azlj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject4));
      ((TextView)localObject1).setText(ajjy.a(2131635913));
      label311:
      ((SingleLineTextView)localObject2).setText(paramRespEncounterInfo.strDescription);
      ((SingleLineTextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(0, 0);
      ((View)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      i = this.jdField_a_of_type_Int - (int)(189.0F * this.jdField_a_of_type_Float);
      localObject1 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      localObject2 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      localObject3 = (VipOpenInfo)paramRespEncounterInfo.vipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localObject3 == null) || (!((VipOpenInfo)localObject3).bOpen)) {
        break label870;
      }
      i -= (int)Math.ceil(33.5F * this.jdField_a_of_type_Float);
    }
    label449:
    label1092:
    for (;;)
    {
      int j = i;
      if (paramRespEncounterInfo.authFlag == 1) {
        j = i - (int)Math.ceil(20.0F * this.jdField_a_of_type_Float);
      }
      i = j;
      if (paramRespEncounterInfo.watch_color != 0) {
        i = j - (int)Math.ceil(16.0F * this.jdField_a_of_type_Float);
      }
      localSingleLineTextView1.setMaxWidth(i);
      i = 0;
      localObject1 = new StringBuilder();
      switch (paramRespEncounterInfo.cSex)
      {
      default: 
        if (paramRespEncounterInfo.cAge != 0) {
          ((StringBuilder)localObject1).append(" ").append(String.valueOf(paramRespEncounterInfo.cAge));
        }
        if (paramRespEncounterInfo.constellation == 0)
        {
          label581:
          if ((paramRespEncounterInfo.profession_id > 0) && (paramRespEncounterInfo.profession_id < 14)) {
            break label980;
          }
          label597:
          if (((StringBuilder)localObject1).length() <= 0) {
            break label1003;
          }
          i = 1;
          paramView.setText(((StringBuilder)localObject1).toString());
          if (AppSetting.c) {
            paramView.setContentDescription(((StringBuilder)localObject1).toString());
          }
          paramView.setVisibility(0);
          label636:
          if (paramRespEncounterInfo.charm_shown != 1) {
            break label1045;
          }
          if (localImageView4.getVisibility() != 0) {
            localImageView4.setVisibility(0);
          }
          switch (paramRespEncounterInfo.charm_level)
          {
          default: 
            localImageView4.setImageResource(2130844509);
            if (AppSetting.c) {
              localImageView4.setContentDescription(ajjy.a(2131635915));
            }
            label713:
            if (paramRespEncounterInfo.watch_color == 0)
            {
              localView.setVisibility(8);
              label727:
              if (paramRespEncounterInfo.nFaceNum < 6) {
                break label1072;
              }
              i += 1;
              localImageView3.setVisibility(0);
              label746:
              if (i <= 0) {
                break label1082;
              }
              localLinearLayout.setVisibility(0);
            }
            break;
          }
        }
        break;
      }
      for (;;)
      {
        a(paramRespEncounterInfo.vipBaseInfo, localImageView2, localSingleLineTextView1);
        a(paramRespEncounterInfo, localImageView1);
        a(localSingleLineTextView2, paramRespEncounterInfo);
        return;
        localSingleLineTextView1.setText("");
        break;
        ((ImageView)localObject4).setVisibility(8);
        break label222;
        localImageView5.setBackgroundResource(2130844961);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844594);
        ((TextView)localObject1).setBackgroundDrawable(azlj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(ajjy.a(2131635916));
        break label311;
        label860:
        localImageView5.setVisibility(8);
        break label311;
        label870:
        if ((localObject1 != null) && (((VipOpenInfo)localObject1).bOpen))
        {
          i -= (int)Math.ceil(33.5F * this.jdField_a_of_type_Float);
          break label449;
        }
        if ((localObject2 == null) || (!((VipOpenInfo)localObject2).bOpen)) {
          break label1092;
        }
        i -= (int)Math.ceil(28.5F * this.jdField_a_of_type_Float);
        break label449;
        ((StringBuilder)localObject1).append("男");
        break label548;
        ((StringBuilder)localObject1).append("女");
        break label548;
        ((StringBuilder)localObject1).append(" ").append(azyk.a(paramRespEncounterInfo.constellation));
        break label581;
        label980:
        ((StringBuilder)localObject1).append(" ").append(azyf.e[paramRespEncounterInfo.profession_id]);
        break label597;
        label1003:
        paramView.setVisibility(8);
        break label636;
        localImageView4.setImageResource(2130844511);
        break label696;
        localImageView4.setImageResource(2130844512);
        break label696;
        localImageView4.setImageResource(2130844513);
        break label696;
        if (localImageView4.getVisibility() == 4) {
          break label713;
        }
        localImageView4.setVisibility(4);
        break label713;
        localView.setVisibility(0);
        break label727;
        localImageView3.setVisibility(8);
        break label746;
        localLinearLayout.setVisibility(8);
      }
    }
  }
  
  public void a(List<RespEncounterInfo> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      RespEncounterInfo localRespEncounterInfo = (RespEncounterInfo)paramList.get(i);
      View localView = a(localRespEncounterInfo);
      if ((localView != null) && (localRespEncounterInfo != null)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, azvv.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (RespEncounterInfo)paramView.getTag();
    paramView = (ajjj)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(51);
    if (paramView != null) {}
    for (boolean bool = paramView.b(Long.toString(((RespEncounterInfo)localObject).lEctID));; bool = false)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      localIntent.putExtra("uin", Long.toString(((RespEncounterInfo)localObject).lEctID));
      localIntent.putExtra("from_where_to_aio", "nearby_recommend_people");
      if (bool)
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("rich_accost_sig", ((RespEncounterInfo)localObject).sig);
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131628878);
        if (!"0".equals(String.valueOf(((RespEncounterInfo)localObject).cSex))) {
          break label282;
        }
      }
      label282:
      for (paramView = String.format(paramView, new Object[] { ajjy.a(2131635914) });; paramView = String.format(paramView, new Object[] { ajjy.a(2131635912) }))
      {
        atcl.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, Long.toString(((RespEncounterInfo)localObject).lEctID), Long.toString(((RespEncounterInfo)localObject).lEctID), paramView, 1001, true, true);
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
        paramView = Long.toString(((RespEncounterInfo)localObject).lEctID);
        localObject = atcl.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
        awqx.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X80055FC", "0X80055FC", 0, 0, localObject[0], paramView, "", "");
        return;
        localIntent.putExtra("uintype", 1001);
        break;
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CarrierHelper", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Azwg.a())) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    paramInt1 = 0;
    label80:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt1);
      if (localObject != null) {
        break label107;
      }
    }
    label107:
    RespEncounterInfo localRespEncounterInfo;
    do
    {
      paramInt1 += 1;
      break label80;
      break;
      localRespEncounterInfo = (RespEncounterInfo)((View)localObject).getTag();
      localObject = (ImageView)((View)localObject).findViewById(16908294);
    } while ((localObject == null) || (localRespEncounterInfo == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(Long.toString(localRespEncounterInfo.lEctID))));
    ((ImageView)localObject).setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atck
 * JD-Core Version:    0.7.0.1
 */