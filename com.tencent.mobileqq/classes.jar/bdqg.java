import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class bdqg
  extends bdnv
{
  public GradientDrawable a;
  public Bundle a;
  View.OnClickListener a;
  public boolean a;
  private String ac;
  public boolean b;
  
  public bdqg()
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdqh(this);
  }
  
  private FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, AIOUtils.dp2px(105.0F, paramContext.getResources())));
    localFrameLayout.setId(2131371839);
    if (AppSetting.c) {
      localFrameLayout.setContentDescription(this.ac);
    }
    return localFrameLayout;
  }
  
  public static String a(AbsStructMsg paramAbsStructMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAbsStructMsg instanceof AbsShareMsg))
    {
      paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
      if ((paramAbsStructMsg.getItemCount() > 0) && ((paramAbsStructMsg.getItemByIndex(0) instanceof bdqg)))
      {
        paramAbsStructMsg = (bdqg)paramAbsStructMsg.getItemByIndex(0);
        boolean bool = paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
        localStringBuilder.append("isSend:").append(bool).append(" nick:");
        if (!bool) {
          break label97;
        }
        localStringBuilder.append(paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getString("rNick"));
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label97:
      localStringBuilder.append(paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getString("sNick"));
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof AbsShareMsg)) && (paramChatMessage.structingMsg.mMsgServiceID == 52))
      {
        paramChatMessage = (AbsShareMsg)paramChatMessage.structingMsg;
        if ((paramChatMessage.getItemCount() > 0) && ((paramChatMessage.getItemByIndex(0) instanceof bdqg))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = null;
    }
    try
    {
      localObject = Base64.decode(paramString, 0);
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (localObject.length > 0) {
          str = new String((byte[])localObject);
        }
      }
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localIllegalArgumentException.getMessage());
          localObject = str;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localException.getMessage());
          localObject = str;
        }
      }
    }
  }
  
  @TargetApi(11)
  private void e(View paramView)
  {
    paramView.setOnTouchListener(new bdqi(this, paramView));
  }
  
  public void a()
  {
    label1165:
    label1297:
    label1312:
    label1328:
    label1464:
    try
    {
      localObject8 = new JSONObject(this.h);
      if (QLog.isColorLevel()) {
        QLog.i("StructMsgItemLayout12", 2, ((JSONObject)localObject8).toString());
      }
      if (!((JSONObject)localObject8).has("fMean")) {
        break label1312;
      }
      localObject3 = ((JSONObject)localObject8).getString("fMean");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        boolean bool1;
        if (QLog.isColorLevel()) {
          QLog.i("StructMsgItemLayout12", 2, localJSONException.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      label1336:
      for (;;)
      {
        Object localObject8;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str11;
        Object localObject7;
        String str10;
        String str12;
        String str13;
        String str14;
        Object localObject9;
        int j;
        label1215:
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localException.getMessage());
          continue;
          localObject4 = localException;
          Object localObject2 = localObject3;
          localObject3 = localObject4;
          break label1297;
          localObject9 = null;
          continue;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          continue;
          localObject3 = "";
          continue;
          localObject2 = "";
          continue;
          localObject4 = "";
          continue;
          localObject5 = "";
          continue;
          label1344:
          localObject6 = "";
          continue;
          label1352:
          str1 = "";
          continue;
          label1360:
          str2 = "";
          continue;
          label1368:
          str3 = "";
          continue;
          label1376:
          str4 = "";
          continue;
          label1384:
          str5 = "";
          continue;
          label1392:
          str6 = "";
          continue;
          label1400:
          str7 = "";
          continue;
          str8 = "";
          continue;
          str9 = "";
          continue;
          str11 = "";
          continue;
          localObject7 = "";
          continue;
          str10 = "";
          continue;
          str12 = "";
          continue;
          str13 = "";
          continue;
          str14 = "";
          continue;
          label1472:
          localObject8 = "";
          continue;
          label1480:
          j = 0;
          continue;
          label1485:
          j = 0;
          continue;
          label1490:
          localObject3 = str11;
          continue;
          label1497:
          localObject3 = "送你";
        }
      }
    }
    if (((JSONObject)localObject8).has("cMean"))
    {
      localObject1 = ((JSONObject)localObject8).getString("cMean");
      if (!((JSONObject)localObject8).has("bgPic")) {
        break label1328;
      }
      localObject4 = ((JSONObject)localObject8).getString("bgPic");
      if (!((JSONObject)localObject8).has("fPic")) {
        break label1336;
      }
      localObject5 = ((JSONObject)localObject8).getString("fPic");
      if (!((JSONObject)localObject8).has("sinfo")) {
        break label1344;
      }
      localObject6 = ((JSONObject)localObject8).getString("sinfo");
      if (!((JSONObject)localObject8).has("rinfo")) {
        break label1352;
      }
      str1 = ((JSONObject)localObject8).getString("rinfo");
      if (!((JSONObject)localObject8).has("score")) {
        break label1360;
      }
      str2 = ((JSONObject)localObject8).getString("score");
      if (!((JSONObject)localObject8).has("pID")) {
        break label1368;
      }
      str3 = ((JSONObject)localObject8).getString("pID");
      if (!((JSONObject)localObject8).has("pURL")) {
        break label1376;
      }
      str4 = ((JSONObject)localObject8).getString("pURL");
      if (!((JSONObject)localObject8).has("fCount")) {
        break label1384;
      }
      str5 = ((JSONObject)localObject8).getString("fCount");
      if (!((JSONObject)localObject8).has("rUin")) {
        break label1392;
      }
      str6 = ((JSONObject)localObject8).getString("rUin");
      if (!((JSONObject)localObject8).has("sUin")) {
        break label1400;
      }
      str7 = ((JSONObject)localObject8).getString("sUin");
      if (!((JSONObject)localObject8).has("rSex")) {
        break label1408;
      }
      str8 = ((JSONObject)localObject8).getString("rSex");
      if (!((JSONObject)localObject8).has("sSex")) {
        break label1416;
      }
      str9 = ((JSONObject)localObject8).getString("sSex");
      if (!((JSONObject)localObject8).has("rNick")) {
        break label1424;
      }
      str11 = ((JSONObject)localObject8).getString("rNick");
      if (!((JSONObject)localObject8).has("sNick")) {
        break label1432;
      }
      localObject7 = ((JSONObject)localObject8).getString("sNick");
      if (!((JSONObject)localObject8).has("version")) {
        break label1440;
      }
      str10 = ((JSONObject)localObject8).getString("version");
      if (!((JSONObject)localObject8).has("groupCode")) {
        break label1448;
      }
      str12 = ((JSONObject)localObject8).getString("groupCode");
      if (!((JSONObject)localObject8).has("gScore")) {
        break label1456;
      }
      str13 = ((JSONObject)localObject8).getString("gScore");
      if (!((JSONObject)localObject8).has("sID")) {
        break label1464;
      }
      str14 = ((JSONObject)localObject8).getString("sID");
      if (!((JSONObject)localObject8).has("aNony")) {
        break label1472;
      }
      localObject8 = ((JSONObject)localObject8).getString("aNony");
      if (TextUtils.isEmpty(str5)) {}
      for (i = 0;; i = Integer.valueOf(str5).intValue())
      {
        localObject9 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
        bool1 = str7.equals(localObject9);
        boolean bool2 = str6.equals(localObject9);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isSend", bool1);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isReceive", bool2);
        localObject9 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!((Iterator)localObject9).hasNext()) {
            break;
          }
          localObject10 = (bdnu)((Iterator)localObject9).next();
        } while (!(localObject10 instanceof bdpx));
        localObject9 = ((bdpx)localObject10).ac;
        str11 = b(str11);
        String str15 = b((String)localObject7);
        localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        Object localObject10 = (anvk)((QQAppInterface)localObject7).getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.jdField_a_of_type_AndroidOsBundle.putString("sNick", str15);
        if (!bool1)
        {
          if ((localObject10 == null) || (!((anvk)localObject10).b(str7))) {
            break label1480;
          }
          j = 1;
          if (j != 0)
          {
            str15 = ContactUtils.getFriendDisplayName((QQAppInterface)localObject7, str7);
            this.jdField_a_of_type_AndroidOsBundle.putString("sNick", str15);
            if (bool2) {
              this.jdField_a_of_type_AndroidOsBundle.putBoolean("isFriend", true);
            }
          }
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("rNick", str11);
        if (!bool2)
        {
          if ((localObject10 == null) || (!((anvk)localObject10).b(str6))) {
            break label1485;
          }
          j = 1;
          if (j != 0)
          {
            localObject7 = ContactUtils.getFriendDisplayName((QQAppInterface)localObject7, str6);
            this.jdField_a_of_type_AndroidOsBundle.putString("rNick", (String)localObject7);
            if (bool1) {
              this.jdField_a_of_type_AndroidOsBundle.putBoolean("isFriend", true);
            }
          }
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("rUin", str6);
        this.jdField_a_of_type_AndroidOsBundle.putString("sUin", str7);
        this.jdField_a_of_type_AndroidOsBundle.putString("rSex", str8);
        this.jdField_a_of_type_AndroidOsBundle.putString("sSex", str9);
        this.jdField_a_of_type_AndroidOsBundle.putString("bgPic", (String)localObject4);
        this.jdField_a_of_type_AndroidOsBundle.putString("sInfo", (String)localObject6);
        this.jdField_a_of_type_AndroidOsBundle.putString("rInfo", str1);
        this.jdField_a_of_type_AndroidOsBundle.putString("score", str2);
        this.jdField_a_of_type_AndroidOsBundle.putString("fPic", (String)localObject5);
        this.jdField_a_of_type_AndroidOsBundle.putString("fMean", (String)localObject3);
        this.jdField_a_of_type_AndroidOsBundle.putString("cMean", (String)localObject1);
        this.jdField_a_of_type_AndroidOsBundle.putString("fCount", str5);
        this.jdField_a_of_type_AndroidOsBundle.putInt("count", i);
        this.jdField_a_of_type_AndroidOsBundle.putString("pID", str3);
        this.jdField_a_of_type_AndroidOsBundle.putString("pURL", str4);
        this.jdField_a_of_type_AndroidOsBundle.putString("version", str10);
        this.jdField_a_of_type_AndroidOsBundle.putString("groupCode", str12);
        this.jdField_a_of_type_AndroidOsBundle.putString("gScore", str13);
        if (!TextUtils.isEmpty((CharSequence)localObject9)) {
          this.jdField_a_of_type_AndroidOsBundle.putString("cover", (String)localObject9);
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("sID", str14);
        if (!TextUtils.isEmpty((CharSequence)localObject8)) {
          this.jdField_a_of_type_AndroidOsBundle.putString("anonyInfo", (String)localObject8);
        }
        if ((!AppSetting.c) || (this.ac != null)) {
          break label1215;
        }
        localObject5 = new StringBuilder();
        if (!bool1) {
          break label1490;
        }
        localObject3 = "我";
        ((StringBuilder)localObject5).append((String)localObject3);
        if (!bool1) {
          break label1497;
        }
        localObject3 = "送出";
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append((String)localObject1).append(',');
        localObject1 = null;
        localObject3 = null;
        localObject6 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject6).hasNext()) {
          break label1165;
        }
        localObject4 = (bdnu)((Iterator)localObject6).next();
        str1 = ((bdnu)localObject4).jdField_a_of_type_JavaLangString;
        if (!"remark".equals(str1)) {
          break;
        }
        localObject4 = ((bdsu)localObject4).b();
        localObject3 = localObject1;
        localObject1 = localObject4;
        break label1297;
      }
      if ("summary".equals(str1))
      {
        localObject4 = ((bdsv)localObject4).b();
        localObject1 = localObject3;
        localObject3 = localObject4;
        break label1297;
        ((StringBuilder)localObject5).append((String)localObject1).append(",");
        if (bool1) {
          ((StringBuilder)localObject5).append("对方").append((String)localObject3);
        }
        for (;;)
        {
          ((StringBuilder)localObject5).append("按钮");
          this.ac = ((StringBuilder)localObject5).toString();
          this.jdField_a_of_type_Boolean = true;
          return;
          ((StringBuilder)localObject5).append((String)localObject3);
        }
      }
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "readExternal inited:" + this.jdField_a_of_type_Boolean + " " + hashCode());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public boolean a(bdpl parambdpl)
  {
    boolean bool = super.a(parambdpl);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "fromXml inited:" + this.jdField_a_of_type_Boolean + " " + hashCode());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    return bool;
  }
  
  protected int b()
  {
    return 12;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayout12", 2, "getView inited:" + this.jdField_a_of_type_Boolean + " " + hashCode());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isReceive", false);
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("groupCode");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("rNick");
    Object localObject1;
    Resources localResources;
    if (!TextUtils.isEmpty(str1)) {
      if (bool1)
      {
        localObject1 = "0X800638D";
        anzp.a(((BaseActivity)paramContext).app, (String)localObject1);
        localResources = paramContext.getResources();
        if ((paramView == null) || (!(paramView instanceof FrameLayout)) || (((FrameLayout)paramView).getChildCount() != 2) || (!(((FrameLayout)paramView).getTag() instanceof bdqj))) {
          break label523;
        }
        localObject1 = (FrameLayout)paramView;
        paramView = (bdqj)((FrameLayout)localObject1).getTag();
        if (paramView.c != null) {
          paramView.c.setVisibility(8);
        }
        if (paramView.d != null) {
          paramView.d.setVisibility(8);
        }
        if (paramView.jdField_b_of_type_AndroidViewView != null) {
          paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (paramView.e == null) {
          break label1517;
        }
        paramView.e.setVisibility(8);
      }
    }
    label279:
    label288:
    label838:
    label1238:
    label1244:
    label1517:
    for (;;)
    {
      Object localObject2;
      if (bool1)
      {
        paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, AIOUtils.dp2px(15.0F, localResources), 0);
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (bdnu)((Iterator)localObject2).next();
          ((bdnu)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          Object localObject4 = ((bdnu)localObject3).jdField_a_of_type_JavaLangString;
          Object localObject5;
          int i;
          if ("title".equals(localObject4))
          {
            if ((localObject3 instanceof StructMsgItemTitle))
            {
              ((StructMsgItemTitle)localObject3).a(a(), 0);
              ((StructMsgItemTitle)localObject3).a(true);
              ((StructMsgItemTitle)localObject3).b(true);
            }
            localObject4 = ((bdnu)localObject3).a(paramContext, paramView.c, paramBundle);
            localObject5 = (TextView)((View)localObject4).findViewById(2131380210);
            if (paramView.c == null)
            {
              paramView.c = ((View)localObject4);
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, 0);
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label838;
              }
              QLog.i("StructMsgItemLayout12", 2, "getview title:" + ((bdnw)localObject3).b() + " realText:" + ((TextView)localObject5).getText());
              break label288;
              if (bool2)
              {
                localObject1 = "0X800638E";
                break;
              }
              localObject1 = "0X800638F";
              break;
              if (bool1)
              {
                localObject1 = "0X80060B1";
                break;
              }
              localObject1 = "0X80060B2";
              break;
              paramView = new bdqj();
              localObject1 = a(paramContext);
              ((FrameLayout)localObject1).setTag(paramView);
              paramView.jdField_a_of_type_AndroidViewView = new View(paramContext);
              localObject2 = new FrameLayout.LayoutParams(-1, -1);
              ((FrameLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
              ((FrameLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.dp2px(10.0F, localResources), 0, 0);
              if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable == null)
              {
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
                this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(AIOUtils.dp2px(14.0F, localResources));
              }
              paramView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
              paramView.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
              paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
              localObject2 = new FrameLayout.LayoutParams(-2, -1);
              paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
              ((FrameLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
              localObject2 = new LinearLayout.LayoutParams(AIOUtils.dp2px(135.0F, localResources), -2);
              ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
              ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(5.0F, localResources);
              localObject3 = paramView.jdField_b_of_type_AndroidWidgetLinearLayout;
              if (bool1) {}
              for (i = 5;; i = 3)
              {
                ((LinearLayout)localObject3).setGravity(i);
                paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
                break;
              }
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(AIOUtils.dp2px(15.0F, localResources), 0, 0, 0);
              break label279;
              paramView.c.setVisibility(0);
            }
          }
          else
          {
            if ("summary".equals(localObject4))
            {
              if ((localObject3 instanceof bdsv)) {
                ((bdsv)localObject3).b("black");
              }
              localObject4 = ((bdnu)localObject3).a(paramContext, paramView.d, paramBundle);
              localObject5 = (TextView)localObject4;
              if (!TextUtils.isEmpty(str1))
              {
                ((TextView)localObject5).setMaxLines(1);
                if ((localObject3 instanceof bdsv)) {
                  ((bdsv)localObject3).a(str2);
                }
                if (paramView.d != null) {
                  break label1026;
                }
                paramView.d = ((View)localObject4);
                localObject5 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject5).setMargins(0, AIOUtils.dp2px(4.0F, localResources), 0, 0);
                paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              }
              for (;;)
              {
                localObject3 = (bdsv)localObject3;
                if ((this.jdField_a_of_type_AndroidOsBundle.size() <= 0) || (!TextUtils.isEmpty(str1))) {
                  break;
                }
                this.jdField_a_of_type_AndroidOsBundle.putString("cMeanPostfix", ((bdsv)localObject3).b());
                break;
                ((TextView)localObject5).setMaxLines(2);
                break label922;
                paramView.d.setVisibility(0);
              }
            }
            if ("picture".equals(localObject4))
            {
              localObject4 = (bdpx)localObject3;
              if (!((bdpx)localObject4).ac.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 4))) {
                ((bdpx)localObject4).ac = String.format("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", new Object[] { ((bdpx)localObject4).ac });
              }
              localObject3 = ((bdnu)localObject3).a(paramContext, paramView.jdField_b_of_type_AndroidViewView, paramBundle);
              if (this.jdField_a_of_type_AndroidOsBundle.getInt("count", 0) > 9)
              {
                ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_END);
                label1137:
                if (paramView.jdField_b_of_type_AndroidViewView != null) {
                  break label1244;
                }
                paramView.jdField_b_of_type_AndroidViewView = ((View)localObject3);
                paramView.jdField_b_of_type_AndroidViewView.setFocusable(true);
                localObject4 = new LinearLayout.LayoutParams(AIOUtils.dp2px(115.0F, localResources), -1);
                ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
                localObject5 = paramView.jdField_a_of_type_AndroidWidgetLinearLayout;
                if (!bool1) {
                  break label1238;
                }
                i = 0;
                ((LinearLayout)localObject5).addView((View)localObject3, i, (ViewGroup.LayoutParams)localObject4);
              }
              for (;;)
              {
                if (!VersionUtils.isHoneycomb()) {
                  break label1286;
                }
                e(paramView.jdField_b_of_type_AndroidViewView);
                break;
                ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
                break label1137;
                i = 1;
                break label1196;
                paramView.jdField_b_of_type_AndroidViewView.setVisibility(0);
                if (bool1 != paramView.jdField_a_of_type_Boolean) {
                  if (bool1) {
                    paramView.jdField_b_of_type_AndroidWidgetLinearLayout.bringToFront();
                  } else {
                    paramView.jdField_b_of_type_AndroidViewView.bringToFront();
                  }
                }
              }
              paramView.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            }
            else if ("remark".equals(localObject4))
            {
              if ((localObject3 instanceof bdsu)) {
                ((bdsu)localObject3).b("#FF9B9B9B");
              }
              localObject4 = ((bdnu)localObject3).a(paramContext, paramView.e, paramBundle);
              if (paramView.e == null)
              {
                paramView.e = ((View)localObject4);
                localObject5 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject5).topMargin = AIOUtils.dp2px(7.0F, localResources);
                paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              }
              for (;;)
              {
                localObject4 = (bdsu)localObject3;
                if (this.jdField_a_of_type_AndroidOsBundle.size() > 0)
                {
                  this.jdField_a_of_type_AndroidOsBundle.putString("remark", ((bdsu)localObject4).b());
                  if (!TextUtils.isEmpty(str1)) {
                    this.jdField_a_of_type_AndroidOsBundle.putString("cMeanPostfix", ((bdsu)localObject4).b());
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("StructMsgItemLayout12", 2, "getview remark:" + ((bdnw)localObject3).b());
                break;
                paramView.e.setVisibility(0);
              }
            }
          }
        }
      }
      paramView.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
      paramView.jdField_a_of_type_Boolean = bool1;
      return localObject1;
    }
  }
  
  public String b()
  {
    return "Layout12";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqg
 * JD-Core Version:    0.7.0.1
 */