package com.tencent.falco.base.toast;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.falco.base.libapi.toast.ToastInterface;

public class ToastComponent
  implements ToastInterface
{
  private Context context;
  
  private int calOffset()
  {
    int i = (int)TypedValue.applyDimension(1, 76.0F, this.context.getResources().getDisplayMetrics());
    if (this.context.getResources().getConfiguration().orientation != 1) {
      i = (int)TypedValue.applyDimension(1, 38.0F, this.context.getResources().getDisplayMetrics());
    }
    return i;
  }
  
  public void clearEventOutput() {}
  
  public Toast makeToast(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this.context).inflate(2131559234, null, false);
    ImageView localImageView = (ImageView)localView.findViewById(2131369538);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          localImageView.setImageResource(2130840471);
        } else {
          localImageView.setImageResource(2130840472);
        }
      }
      else {
        localImageView.setImageResource(2130840473);
      }
    }
    else {
      localImageView.setImageResource(2130840474);
    }
    ((TextView)localView.findViewById(2131379776)).setText(paramString);
    paramString = new Toast(this.context);
    paramString.setView(localView);
    paramString.setGravity(49, 0, calOffset());
    return paramString;
  }
  
  public void onCreate(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void onDestroy() {}
  
  public void showToast(int paramInt)
  {
    showToast(paramInt, 1, false);
  }
  
  public void showToast(int paramInt1, int paramInt2)
  {
    showToast(paramInt1, paramInt2, false);
  }
  
  public void showToast(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    showToast(this.context.getString(paramInt1), paramInt2, paramBoolean);
  }
  
  public void showToast(int paramInt, boolean paramBoolean)
  {
    showToast(paramInt, 1, paramBoolean);
  }
  
  public void showToast(String paramString)
  {
    showToast(paramString, 1, false);
  }
  
  public void showToast(String paramString, int paramInt)
  {
    showToast(paramString, paramInt, false);
  }
  
  public void showToast(String paramString, int paramInt, boolean paramBoolean)
  {
    showToast(paramString, paramInt, paramBoolean, calOffset());
  }
  
  public void showToast(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramString = makeToast(paramString, paramInt1);
    paramString.setGravity(49, 0, paramInt2);
    paramString.show();
  }
  
  public void showToast(String paramString, boolean paramBoolean)
  {
    showToast(paramString, 1, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.toast.ToastComponent
 * JD-Core Version:    0.7.0.1
 */