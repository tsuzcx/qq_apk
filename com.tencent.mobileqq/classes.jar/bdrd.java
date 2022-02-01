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

public class bdrd
  extends bdom
{
  protected String ac;
  
  private void a(Context paramContext, bdol parambdol, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    parambdol = (bdqo)parambdol;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "logo url = " + parambdol.ac);
    }
    if (TextUtils.isEmpty(parambdol.ac)) {
      return;
    }
    try
    {
      new URL(parambdol.ac);
      paramBundle = paramContext.getResources();
      int i = agej.a(44.0F, paramBundle);
      paramContext = new URLImageView(paramContext);
      paramContext.setAdjustViewBounds(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, agej.a(16.0F, paramBundle), agej.a(18.0F, paramBundle), agej.a(14.0F, paramBundle));
      localLayoutParams.addRule(11);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      paramContext.setLayoutParams(localLayoutParams);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = i;
      paramBundle.mRequestHeight = i;
      parambdol = URLDrawable.getDrawable(parambdol.ac, paramBundle);
      parambdol.setAutoDownload(true);
      if (parambdol.getStatus() == 2) {
        parambdol.restartDownload();
      }
      paramContext.setImageDrawable(parambdol);
      paramContext.setId(2131378074);
      paramViewGroup.addView(paramContext);
      return;
    }
    catch (MalformedURLException paramContext) {}
  }
  
  private void a(Context paramContext, bdol parambdol, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)parambdol.a(paramContext, null, paramBundle);
    parambdol = new RelativeLayout.LayoutParams(-2, -2);
    parambdol.setMargins(agej.a(19.0F, localResources), agej.a(4.5F, localResources), 0, 0);
    parambdol.addRule(3, 2131378075);
    if (paramBoolean)
    {
      parambdol.addRule(0, 2131378074);
      parambdol.addRule(9);
    }
    paramContext.setLayoutParams(parambdol);
    paramContext.setSingleLine();
    paramViewGroup.addView(paramContext);
  }
  
  private void a(Context paramContext, bdol parambdol, Bundle paramBundle, QQWalletTransferBubbleView paramQQWalletTransferBubbleView)
  {
    try
    {
      i = Color.parseColor(((bdti)parambdol).g());
      paramQQWalletTransferBubbleView.setBubbleBackground(2130847249, i, true);
      Resources localResources = paramContext.getResources();
      paramContext = (TextView)parambdol.a(paramContext, null, paramBundle);
      parambdol = new RelativeLayout.LayoutParams(-2, -2);
      parambdol.setMargins(agej.a(19.0F, localResources), 0, 0, 0);
      parambdol.addRule(15);
      paramContext.setLayoutParams(parambdol);
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
  
  private void b(Context paramContext, bdol parambdol, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)parambdol.a(paramContext, null, paramBundle);
    parambdol = new RelativeLayout.LayoutParams(-2, -2);
    parambdol.setMargins(agej.a(19.0F, localResources), agej.a(11.0F, localResources), 0, 0);
    if (paramBoolean)
    {
      parambdol.addRule(0, 2131378074);
      parambdol.addRule(9);
    }
    paramContext.setLayoutParams(parambdol);
    paramContext.setSingleLine();
    paramContext.setId(2131378075);
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
  
  public boolean a(bdqc parambdqc)
  {
    boolean bool = super.a(parambdqc);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "from xml");
    }
    this.ac = parambdqc.a("bgColor");
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
      ((QQWalletTransferBubbleView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, agej.a(74.0F, (Resources)localObject1)));
      try
      {
        i = Color.parseColor(this.ac);
        ((QQWalletTransferBubbleView)localObject2).setBubbleBackground(2130847248, i, true);
        paramView.addView((View)localObject2);
        QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
        localQQWalletTransferBubbleView.setLayoutParams(new LinearLayout.LayoutParams(-1, agej.a(25.0F, (Resources)localObject1)));
        paramView.addView(localQQWalletTransferBubbleView);
        localObject1 = this.a.iterator();
        bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          bdol localbdol = (bdol)((Iterator)localObject1).next();
          if ((localbdol instanceof bdqo))
          {
            a(paramContext, localbdol, paramBundle, (ViewGroup)localObject2);
            bool = true;
            continue;
            paramView = new LinearLayout(paramContext);
            paramView.setOrientation(1);
            paramView.setGravity(1);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, agej.a(3.0F, (Resources)localObject1), 0, 0);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramView.setId(2131378073);
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
          localObject1 = (bdol)this.a.get(i);
          if ((localObject1 instanceof StructMsgItemTitle)) {
            b(paramContext, (bdol)localObject1, paramBundle, (ViewGroup)localObject2, bool);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject1 instanceof bdtj)) {
              a(paramContext, (bdol)localObject1, paramBundle, (ViewGroup)localObject2, bool);
            } else if ((localObject1 instanceof bdti)) {
              a(paramContext, (bdol)localObject1, paramBundle, localException);
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
 * Qualified Name:     bdrd
 * JD-Core Version:    0.7.0.1
 */