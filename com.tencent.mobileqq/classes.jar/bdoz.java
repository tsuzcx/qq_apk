import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlSerializer;

public class bdoz
  extends bdnu
{
  Context jdField_a_of_type_AndroidContentContext = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  List<bdnu> jdField_a_of_type_JavaUtilList = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  long c;
  int o;
  
  public bdoz()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "groupitem";
  }
  
  private View a(View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramView.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    Object localObject = new ImageView(paramView.getContext());
    ((ImageView)localObject).setImageResource(2130844399);
    int i = AIOUtils.dp2px(9.0F, paramView.getResources());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(AIOUtils.dp2px(8.0F, paramView.getResources()), i);
    localLayoutParams.leftMargin = AIOUtils.dp2px(24.0F, paramView.getResources());
    localLayoutParams.rightMargin = AIOUtils.dp2px(4.0F, paramView.getResources());
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramView.setPadding(0, 0, 0, 0);
    localObject = paramView.findViewById(2131380183);
    if (localObject != null) {
      ((View)localObject).setPadding(0, ((View)localObject).getPaddingTop(), 0, ((View)localObject).getPaddingBottom());
    }
    localLinearLayout.addView(paramView);
    return localLinearLayout;
  }
  
  private void a(Resources paramResources, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (this.o == 0)
    {
      paramImageView.setBackgroundDrawable(null);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView.setBackgroundResource(2130844398);
      return;
    }
    paramImageView.setBackgroundResource(2130844397);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources;
    int i;
    label51:
    Object localObject2;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup).setOrientation(1);
      localResources = paramContext.getResources();
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label655;
      }
      localObject2 = (bdnu)this.jdField_a_of_type_JavaUtilList.get(i);
      paramView = ((bdnu)localObject2).jdField_a_of_type_JavaLangString;
      if (!"summary".equals(paramView)) {
        break label334;
      }
      paramView = new LinearLayout(paramContext);
      paramView.setId(2131378141);
      paramView.setOrientation(0);
      localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(42.0F, localResources));
      ((LinearLayout.LayoutParams)localObject1).leftMargin = AIOUtils.dp2px(13.0F, localResources);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(13.0F, localResources);
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      localObject3 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378142);
      if (localObject3 != null) {
        break label323;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      label198:
      localObject1 = ((bdnu)localObject2).a(paramContext, null, paramBundle);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new ImageView(paramContext);
      ((ImageView)localObject1).setId(2131378140);
      a(localResources, (ImageView)localObject1);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.addView((View)localObject1);
    }
    label323:
    label334:
    do
    {
      for (;;)
      {
        i += 1;
        break label51;
        this.jdField_a_of_type_AndroidViewViewGroup = new LinearLayout(paramContext);
        break;
        ((LinearLayout)localObject3).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        break label198;
        if (!"hr".equals(paramView)) {
          break label430;
        }
        paramView = ((bdnu)localObject2).a(paramContext, null, paramBundle);
        localObject1 = new LinearLayout.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378142);
        if (localObject2 == null) {
          this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
        } else {
          ((LinearLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
        }
      }
    } while (!"item".equals(paramView));
    label430:
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378142);
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      paramView.setId(2131378142);
      if (!this.jdField_a_of_type_Boolean) {
        break label646;
      }
      paramView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      paramView.setGravity(16);
      paramView.setBackgroundColor(localResources.getColor(2131167207));
      ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localObject3 = ((bdnu)localObject2).a(paramContext, null, paramBundle);
      localObject1 = a((View)localObject3);
      ((View)localObject3).setBackgroundDrawable(null);
      ((View)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      ((View)localObject1).setTag(localObject2);
      localObject2 = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(48.0F, localResources));
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.o += 1;
      break;
      label646:
      paramView.setVisibility(8);
    }
    label655:
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public String a()
  {
    return "groupitem";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    LinearLayout localLinearLayout;
    do
    {
      return;
      localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378142);
    } while (localLinearLayout == null);
    localLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_AndroidContentContext.getResources(), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378140));
  }
  
  void a(bdnu parambdnu)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambdnu);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    int i = 1;
    super.a(paramObjectInput);
    this.jdField_b_of_type_JavaLangString = paramObjectInput.readUTF();
    this.jdField_c_of_type_JavaLangString = paramObjectInput.readUTF();
    this.d = paramObjectInput.readUTF();
    this.e = paramObjectInput.readUTF();
    this.f = paramObjectInput.readUTF();
    Object localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
      this.jdField_a_of_type_Boolean = true;
    }
    localObject = paramObjectInput.readUTF();
    if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Long = paramObjectInput.readLong();
    int m = paramObjectInput.readInt();
    this.o = 0;
    int k = 0;
    if (k < m)
    {
      localObject = paramObjectInput.readUTF();
      if ("item".equals(localObject))
      {
        localObject = bdoe.a(paramObjectInput.readInt());
        this.o += 1;
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((bdnu)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((bdnu)localObject).a(paramObjectInput);
          a((bdnu)localObject);
        }
        k += 1;
        break;
        bdnu localbdnu = bdoe.a((String)localObject);
        int j = i;
        if ("button".equals(localObject))
        {
          localbdnu.aa = String.valueOf(i);
          localbdnu.ab = this.ab;
          j = i + 1;
        }
        localObject = localbdnu;
        i = j;
        if (localbdnu != null)
        {
          localObject = localbdnu;
          i = j;
          if (bdnv.class.isInstance(localbdnu))
          {
            paramObjectInput.readInt();
            localObject = localbdnu;
            i = j;
          }
        }
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label197;
      }
      localObject = "";
      label34:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.d != null) {
        break label205;
      }
      localObject = "";
      label52:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.e != null) {
        break label213;
      }
      localObject = "";
      label70:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.f != null) {
        break label221;
      }
      localObject = "";
      label88:
      paramObjectOutput.writeUTF((String)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label229;
      }
      localObject = "true";
      label105:
      paramObjectOutput.writeUTF((String)localObject);
      if (!this.jdField_b_of_type_Boolean) {
        break label235;
      }
    }
    label197:
    label205:
    label213:
    label221:
    label229:
    label235:
    for (Object localObject = "true";; localObject = "false")
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilList.size());
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bdnu)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.jdField_b_of_type_JavaLangString;
      break;
      localObject = this.jdField_c_of_type_JavaLangString;
      break label34;
      localObject = this.d;
      break label52;
      localObject = this.e;
      break label70;
      localObject = this.f;
      break label88;
      localObject = "false";
      break label105;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "groupitem");
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "action", this.jdField_c_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.d)) {
      paramXmlSerializer.attribute(null, "actionData", this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      paramXmlSerializer.attribute(null, "a_actionData", this.e);
    }
    if (!TextUtils.isEmpty(this.f)) {
      paramXmlSerializer.attribute(null, "i_actionData", this.f);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      paramXmlSerializer.attribute(null, "url", this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      str = "true";
      paramXmlSerializer.attribute(null, "expand", str);
      if (!this.jdField_b_of_type_Boolean) {
        break label214;
      }
    }
    label214:
    for (String str = "true";; str = "false")
    {
      paramXmlSerializer.attribute(null, "expand", str);
      paramXmlSerializer.attribute(null, "expand", String.valueOf(this.jdField_c_of_type_Long));
      paramXmlSerializer.endTag(null, "groupitem");
      return;
      str = "false";
      break;
    }
  }
  
  public boolean a(bdpl parambdpl)
  {
    boolean bool = false;
    if (parambdpl == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      this.jdField_c_of_type_JavaLangString = parambdpl.a("action");
      this.d = parambdpl.a("actionData");
      this.e = parambdpl.a("a_actionData");
      this.f = parambdpl.a("i_actionData");
      this.jdField_b_of_type_JavaLangString = parambdpl.a("url");
      this.o = 0;
      Object localObject = parambdpl.a("expand");
      if ((localObject != null) && (((String)localObject).toLowerCase().equals("true"))) {
        this.jdField_a_of_type_Boolean = true;
      }
      localObject = parambdpl.a("animation");
      if ((localObject != null) && (((String)localObject).toLowerCase().equals("false"))) {
        this.jdField_b_of_type_Boolean = false;
      }
      localObject = parambdpl.a("duration");
      if (localObject != null) {}
      try
      {
        this.jdField_c_of_type_Long = Long.parseLong((String)localObject);
        label157:
        if ((parambdpl.jdField_a_of_type_JavaUtilList != null) && (parambdpl.a() > 0))
        {
          Iterator localIterator = parambdpl.jdField_a_of_type_JavaUtilList.iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            bdpl localbdpl = (bdpl)localIterator.next();
            if (("summary".equals(localbdpl.jdField_b_of_type_JavaLangString)) || ("hr".equals(localbdpl.jdField_b_of_type_JavaLangString))) {
              parambdpl = bdoe.a(localbdpl.jdField_b_of_type_JavaLangString);
            }
            do
            {
              localObject = parambdpl;
              if (parambdpl == null) {
                break;
              }
              localObject = parambdpl;
              if (!parambdpl.a(localbdpl)) {
                break;
              }
              a(parambdpl);
              localObject = parambdpl;
              break;
              parambdpl = (bdpl)localObject;
            } while (!"item".equals(localbdpl.jdField_b_of_type_JavaLangString));
            parambdpl = localbdpl.a("layout");
            try
            {
              if (!TextUtils.isEmpty(parambdpl)) {}
              for (int i = Integer.parseInt(parambdpl);; i = 0)
              {
                parambdpl = bdoe.a(i);
                this.o += 1;
                break;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (NumberFormatException parambdpl) {}
            QLog.i("StructMsg", 2, "Item layout value is " + 0);
            return false;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        break label157;
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378142);
    } while (localObject1 == null);
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject2 = new bdpb((ViewGroup)localObject1);
        ((bdpb)localObject2).setDuration(this.jdField_c_of_type_Long);
        ((bdpb)localObject2).setInterpolator(new DecelerateInterpolator());
        ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        a(this.jdField_a_of_type_AndroidContentContext.getResources(), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378140));
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break;
        }
        Object localObject3 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
        if ((localObject3 == null) || (TextUtils.isEmpty(this.d))) {
          break;
        }
        localObject2 = "";
        Matcher localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(this.d);
        do
        {
          localObject1 = localObject2;
          if (!localMatcher.find()) {
            break;
          }
        } while (!"QidianKfUin".equals(localMatcher.group(1)));
        localObject1 = localMatcher.group(2);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject2 = (bjyi)((QQAppInterface)localObject3).getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.d).append("&expand=").append(this.jdField_a_of_type_Boolean);
        ((bjyi)localObject2).a(((StringBuilder)localObject3).toString(), 1, false, 0.0D, 0.0D, (String)localObject1, 1, "", "", "");
        return;
        ((LinearLayout)localObject1).setVisibility(8);
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = new bdpa((ViewGroup)localObject1);
      ((bdpa)localObject2).setDuration(this.jdField_c_of_type_Long);
      ((bdpa)localObject2).setInterpolator(new AccelerateInterpolator());
      ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      break;
      ((LinearLayout)localObject1).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoz
 * JD-Core Version:    0.7.0.1
 */