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

public class axxh
  extends axuq
{
  protected String S;
  
  private void a(Context paramContext, axup paramaxup, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    paramaxup = (axws)paramaxup;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "logo url = " + paramaxup.S);
    }
    if (TextUtils.isEmpty(paramaxup.S)) {
      return;
    }
    try
    {
      new URL(paramaxup.S);
      paramBundle = paramContext.getResources();
      int i = actj.a(44.0F, paramBundle);
      paramContext = new URLImageView(paramContext);
      paramContext.setAdjustViewBounds(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, actj.a(16.0F, paramBundle), actj.a(18.0F, paramBundle), actj.a(14.0F, paramBundle));
      localLayoutParams.addRule(11);
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      paramContext.setLayoutParams(localLayoutParams);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = i;
      paramBundle.mRequestHeight = i;
      paramaxup = URLDrawable.getDrawable(paramaxup.S, paramBundle);
      paramaxup.setAutoDownload(true);
      if (paramaxup.getStatus() == 2) {
        paramaxup.restartDownload();
      }
      paramContext.setImageDrawable(paramaxup);
      paramContext.setId(2131376559);
      paramViewGroup.addView(paramContext);
      return;
    }
    catch (MalformedURLException paramContext) {}
  }
  
  private void a(Context paramContext, axup paramaxup, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)paramaxup.a(paramContext, null, paramBundle);
    paramaxup = new RelativeLayout.LayoutParams(-2, -2);
    paramaxup.setMargins(actj.a(19.0F, localResources), actj.a(4.5F, localResources), 0, 0);
    paramaxup.addRule(3, 2131376560);
    if (paramBoolean)
    {
      paramaxup.addRule(0, 2131376559);
      paramaxup.addRule(9);
    }
    paramContext.setLayoutParams(paramaxup);
    paramContext.setSingleLine();
    paramViewGroup.addView(paramContext);
  }
  
  private void a(Context paramContext, axup paramaxup, Bundle paramBundle, QQWalletTransferBubbleView paramQQWalletTransferBubbleView)
  {
    try
    {
      i = Color.parseColor(((axzi)paramaxup).g());
      paramQQWalletTransferBubbleView.setBubbleBackground(2130846330, i, true);
      Resources localResources = paramContext.getResources();
      paramContext = (TextView)paramaxup.a(paramContext, null, paramBundle);
      paramaxup = new RelativeLayout.LayoutParams(-2, -2);
      paramaxup.setMargins(actj.a(19.0F, localResources), 0, 0, 0);
      paramaxup.addRule(15);
      paramContext.setLayoutParams(paramaxup);
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
  
  private void b(Context paramContext, axup paramaxup, Bundle paramBundle, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    paramContext = (TextView)paramaxup.a(paramContext, null, paramBundle);
    paramaxup = new RelativeLayout.LayoutParams(-2, -2);
    paramaxup.setMargins(actj.a(19.0F, localResources), actj.a(11.0F, localResources), 0, 0);
    if (paramBoolean)
    {
      paramaxup.addRule(0, 2131376559);
      paramaxup.addRule(9);
    }
    paramContext.setLayoutParams(paramaxup);
    paramContext.setSingleLine();
    paramContext.setId(2131376560);
    paramViewGroup.addView(paramContext);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "read external");
    }
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "write external");
    }
    super.a(paramObjectOutput);
    if (this.S == null) {}
    for (String str = "";; str = this.S)
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
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "url", this.S);
    }
    super.a(paramXmlSerializer);
  }
  
  public boolean a(axwg paramaxwg)
  {
    boolean bool = super.a(paramaxwg);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout19", 2, "from xml");
    }
    this.S = paramaxwg.a("bgColor");
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
      ((QQWalletTransferBubbleView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, actj.a(74.0F, (Resources)localObject1)));
      try
      {
        i = Color.parseColor(this.S);
        ((QQWalletTransferBubbleView)localObject2).setBubbleBackground(2130846329, i, true);
        paramView.addView((View)localObject2);
        QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
        localQQWalletTransferBubbleView.setLayoutParams(new LinearLayout.LayoutParams(-1, actj.a(25.0F, (Resources)localObject1)));
        paramView.addView(localQQWalletTransferBubbleView);
        localObject1 = this.a.iterator();
        bool = false;
        while (((Iterator)localObject1).hasNext())
        {
          axup localaxup = (axup)((Iterator)localObject1).next();
          if ((localaxup instanceof axws))
          {
            a(paramContext, localaxup, paramBundle, (ViewGroup)localObject2);
            bool = true;
            continue;
            paramView = new LinearLayout(paramContext);
            paramView.setOrientation(1);
            paramView.setGravity(1);
            localObject2 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, actj.a(3.0F, (Resources)localObject1), 0, 0);
            paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            paramView.setId(2131376558);
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsgItemLayout19", 2, "parse item bg color failure, color = " + this.S);
          }
          i = Color.parseColor("#18b4ed");
        }
        int j = this.a.size();
        int i = 0;
        if (i < j)
        {
          localObject1 = (axup)this.a.get(i);
          if ((localObject1 instanceof StructMsgItemTitle)) {
            b(paramContext, (axup)localObject1, paramBundle, (ViewGroup)localObject2, bool);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject1 instanceof axzj)) {
              a(paramContext, (axup)localObject1, paramBundle, (ViewGroup)localObject2, bool);
            } else if ((localObject1 instanceof axzi)) {
              a(paramContext, (axup)localObject1, paramBundle, localException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxh
 * JD-Core Version:    0.7.0.1
 */