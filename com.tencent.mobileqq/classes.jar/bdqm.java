import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public class bdqm
  extends bdnv
{
  protected String ac;
  
  private void a(Context paramContext, bdnu parambdnu, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    parambdnu = (bdpx)parambdnu;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "logo url = " + parambdnu.ac);
    }
    if (TextUtils.isEmpty(parambdnu.ac)) {
      return;
    }
    try
    {
      new URL(parambdnu.ac);
      paramBundle = paramContext.getResources();
      int i = AIOUtils.dp2px(44.0F, paramBundle);
      paramContext = new URLImageView(paramContext);
      paramContext.setAdjustViewBounds(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, AIOUtils.dp2px(16.0F, paramBundle), AIOUtils.dp2px(18.0F, paramBundle), AIOUtils.dp2px(14.0F, paramBundle));
      localLayoutParams.addRule(11);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      paramContext.setLayoutParams(localLayoutParams);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = i;
      paramBundle.mRequestHeight = i;
      parambdnu = URLDrawable.getDrawable(parambdnu.ac, paramBundle);
      parambdnu.setAutoDownload(true);
      if (parambdnu.getStatus() == 2) {
        parambdnu.restartDownload();
      }
      paramContext.setImageDrawable(parambdnu);
      paramContext.setId(2131378126);
      paramViewGroup.addView(paramContext);
      return;
    }
    catch (MalformedURLException paramContext) {}
  }
  
  private void a(Context paramContext, bdnu parambdnu, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)parambdnu.a(paramContext, null, paramBundle);
    parambdnu = new RelativeLayout.LayoutParams(-2, -2);
    parambdnu.setMargins(AIOUtils.dp2px(19.0F, localResources), AIOUtils.dp2px(4.5F, localResources), 0, 0);
    parambdnu.addRule(3, 2131378127);
    if (paramBoolean)
    {
      parambdnu.addRule(0, 2131378126);
      parambdnu.addRule(9);
    }
    paramContext.setLayoutParams(parambdnu);
    paramContext.setSingleLine();
    paramViewGroup.addView(paramContext);
  }
  
  private void a(Context paramContext, bdnu parambdnu, Bundle paramBundle, QQWalletTransferBubbleView paramQQWalletTransferBubbleView)
  {
    try
    {
      i = Color.parseColor(((bdsu)parambdnu).g());
      paramQQWalletTransferBubbleView.setBubbleBackground(2130847255, i, true);
      Resources localResources = paramContext.getResources();
      paramContext = (TextView)parambdnu.a(paramContext, null, paramBundle);
      parambdnu = new RelativeLayout.LayoutParams(-2, -2);
      parambdnu.setMargins(AIOUtils.dp2px(19.0F, localResources), 0, 0, 0);
      parambdnu.addRule(15);
      paramContext.setLayoutParams(parambdnu);
      paramQQWalletTransferBubbleView.addView(paramContext);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = Color.parseColor("#ffffff");
      }
    }
  }
  
  private void b(Context paramContext, bdnu parambdnu, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)parambdnu.a(paramContext, null, paramBundle);
    parambdnu = new RelativeLayout.LayoutParams(-2, -2);
    parambdnu.setMargins(AIOUtils.dp2px(19.0F, localResources), AIOUtils.dp2px(11.0F, localResources), 0, 0);
    if (paramBoolean)
    {
      parambdnu.addRule(0, 2131378126);
      parambdnu.addRule(9);
    }
    paramContext.setLayoutParams(parambdnu);
    paramContext.setSingleLine();
    paramContext.setId(2131378127);
    paramViewGroup.addView(paramContext);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "read external");
    }
    super.a(paramObjectInput);
    this.ac = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "write external");
    }
    super.a(paramObjectOutput);
    if (this.ac == null) {}
    for (String str = "";; str = this.ac)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "to xml");
    }
    if (!TextUtils.isEmpty(this.ac)) {
      paramXmlSerializer.attribute(null, "url", this.ac);
    }
    super.a(paramXmlSerializer);
  }
  
  public boolean a(bdpl parambdpl)
  {
    boolean bool = super.a(parambdpl);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "from xml");
    }
    this.ac = parambdpl.a("bgColor");
    return bool;
  }
  
  protected int b()
  {
    return 19;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    for (;;)
    {
      Object localObject2 = new QQWalletTransferBubbleView(paramContext);
      ((QQWalletTransferBubbleView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(74.0F, (Resources)localObject1)));
      try
      {
        i = Color.parseColor(this.ac);
        ((QQWalletTransferBubbleView)localObject2).setBubbleBackground(2130847254, i, true);
        paramView.addView((View)localObject2);
        QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
        localQQWalletTransferBubbleView.setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(25.0F, (Resources)localObject1)));
        paramView.addView(localQQWalletTransferBubbleView);
        localObject1 = this.a.iterator();
        bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          bdnu localbdnu = (bdnu)((Iterator)localObject1).next();
          if ((localbdnu instanceof bdpx))
          {
            a(paramContext, localbdnu, paramBundle, (ViewGroup)localObject2);
            bool = true;
            continue;
            paramView = new LinearLayout(paramContext);
            paramView.setOrientation(1);
            paramView.setGravity(1);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, AIOUtils.dp2px(3.0F, (Resources)localObject1), 0, 0);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramView.setId(2131378125);
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "parse item bg color failure, color = " + this.ac);
          }
          i = Color.parseColor("#18b4ed");
        }
        int j = this.a.size();
        int i = 0;
        if (i < j)
        {
          localObject1 = (bdnu)this.a.get(i);
          if ((localObject1 instanceof StructMsgItemTitle)) {
            b(paramContext, (bdnu)localObject1, paramBundle, (ViewGroup)localObject2, bool);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject1 instanceof bdsv)) {
              a(paramContext, (bdnu)localObject1, paramBundle, (ViewGroup)localObject2, bool);
            } else if ((localObject1 instanceof bdsu)) {
              a(paramContext, (bdnu)localObject1, paramBundle, localException);
            }
          }
        }
      }
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout19";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqm
 * JD-Core Version:    0.7.0.1
 */