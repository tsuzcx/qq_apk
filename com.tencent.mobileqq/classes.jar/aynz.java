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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.1;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper.2;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class aynz
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bbvn jdField_a_of_type_Bbvn;
  public FaceDecoder a;
  HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  HashMap<Long, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  int c = 0;
  
  public aynz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561284, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373409));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379070));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Bbvn = ((bbvn)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.STATUS_MANAGER));
    paramContext = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("key_nearbyrecommender_title", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694243));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
    }
  }
  
  public static void a(VipBaseInfo paramVipBaseInfo, ImageView paramImageView, SingleLineTextView paramSingleLineTextView)
  {
    paramImageView.setVisibility(8);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167093));
    VipOpenInfo localVipOpenInfo;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(7));
      if ((localVipOpenInfo == null) || (!localVipOpenInfo.bOpen)) {
        break label84;
      }
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130850517);
      paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167168));
    }
    label84:
    do
    {
      return;
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if ((localVipOpenInfo != null) && (localVipOpenInfo.bOpen))
      {
        paramImageView.setVisibility(0);
        paramImageView.setImageResource(2130850517);
        paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167168));
        return;
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    } while ((paramVipBaseInfo == null) || (!paramVipBaseInfo.bOpen));
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130850854);
    paramSingleLineTextView.setTextColor(paramSingleLineTextView.getResources().getColorStateList(2131167168));
  }
  
  private void a(SingleLineTextView paramSingleLineTextView, int paramInt)
  {
    bity localbity = new bity(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Bbvn.a(paramInt, 200), false, false);
    if (this.c == 0) {
      this.c = ((int)(paramSingleLineTextView.getTextSize() * 1.1F + 0.5F));
    }
    localbity.setBounds(0, 0, this.c, this.c);
    paramSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(localbity, null);
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559527, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
            ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.execute(new ChatPushCarrierHelper.1(this, str, paramRespEncounterInfo));
          }
        }
        paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(32, str, 202);
        if (paramRespEncounterInfo == null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(str, 202, true, false);
          }
          if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)bheg.a());
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
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.execute(new ChatPushCarrierHelper.2(this, str, paramRespEncounterInfo));
        }
      }
      paramRespEncounterInfo = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(32, str, 200);
      if (paramRespEncounterInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(str, 200, true, false);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)bheg.a());
        }
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      paramImageView.setImageBitmap(paramRespEncounterInfo);
    }
  }
  
  public void a(View paramView, RespEncounterInfo paramRespEncounterInfo)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131368381);
    SingleLineTextView localSingleLineTextView1 = (SingleLineTextView)paramView.findViewById(2131378659);
    Object localObject4 = (ImageView)paramView.findViewById(2131363080);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131368773);
    Object localObject1 = (TextView)paramView.findViewById(2131378729);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131381243);
    SingleLineTextView localSingleLineTextView2 = (SingleLineTextView)paramView.findViewById(2131365449);
    Object localObject2 = (SingleLineTextView)paramView.findViewById(2131378941);
    Object localObject3 = paramView.findViewById(2131369523);
    TextView localTextView = (TextView)paramView.findViewById(2131371927);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131372643);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131364474);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131377249);
    View localView = paramView.findViewById(2131369606);
    paramView = (SingleLineTextView)paramView.findViewById(2131368893);
    this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167093);
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
      localImageView5.setBackgroundResource(2130845887);
      localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845487);
      ((TextView)localObject1).setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject4));
      ((TextView)localObject1).setText(anvx.a(2131701206));
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
            localImageView4.setImageResource(2130845406);
            if (AppSetting.c) {
              localImageView4.setContentDescription(anvx.a(2131701208));
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
        localImageView5.setBackgroundResource(2130845887);
        localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845487);
        ((TextView)localObject1).setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), -17883, (Drawable)localObject4));
        ((TextView)localObject1).setText(anvx.a(2131701209));
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
        ((StringBuilder)localObject1).append(" ").append(bhaa.a(paramRespEncounterInfo.constellation));
        break label581;
        label980:
        ((StringBuilder)localObject1).append(" ").append(bgzv.e[paramRespEncounterInfo.profession_id]);
        break label597;
        label1003:
        paramView.setVisibility(8);
        break label636;
        localImageView4.setImageResource(2130845408);
        break label696;
        localImageView4.setImageResource(2130845409);
        break label696;
        localImageView4.setImageResource(2130845410);
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
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (RespEncounterInfo)paramView.getTag();
    Object localObject1 = (anvk)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 != null) {}
    for (boolean bool = ((anvk)localObject1).b(Long.toString(((RespEncounterInfo)localObject2).lEctID));; bool = false)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
      localIntent.putExtra("uin", Long.toString(((RespEncounterInfo)localObject2).lEctID));
      localIntent.putExtra("from_where_to_aio", "nearby_recommend_people");
      if (bool)
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("rich_accost_sig", ((RespEncounterInfo)localObject2).sig);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131694224);
        if (!"0".equals(String.valueOf(((RespEncounterInfo)localObject2).cSex))) {
          break label300;
        }
      }
      label300:
      for (localObject1 = String.format((String)localObject1, new Object[] { anvx.a(2131701207) });; localObject1 = String.format((String)localObject1, new Object[] { anvx.a(2131701205) }))
      {
        ayoa.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, Long.toString(((RespEncounterInfo)localObject2).lEctID), Long.toString(((RespEncounterInfo)localObject2).lEctID), (String)localObject1, 1001, true, true);
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
        localObject1 = Long.toString(((RespEncounterInfo)localObject2).lEctID);
        localObject2 = ayoa.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app);
        bdla.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X80055FC", "0X80055FC", 0, 0, localObject2[0], (String)localObject1, "", "");
        EventCollector.getInstance().onViewClicked(paramView);
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
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())) {
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
 * Qualified Name:     aynz
 * JD-Core Version:    0.7.0.1
 */