package com.tencent.luggage.game.widget.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pp.x.a;
import com.tencent.luggage.wxa.qz.o;

final class a$a
  extends FrameLayout
  implements x.a
{
  private View a;
  
  public a$a(@NonNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131624213, this, true);
    ((Button)findViewById(2131433981)).setText(2131886944);
  }
  
  public View a()
  {
    if (this.a == null) {
      this.a = findViewById(2131433981);
    }
    return this.a;
  }
  
  public void a(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    o.d("MicroMsg.WAGameInputPanel", "EditBar setmConfirmButtonPadding tolerate(%d),rightMargin(%d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localLayoutParams.rightMargin) });
    localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin + paramInt, localLayoutParams.bottomMargin);
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a.a
 * JD-Core Version:    0.7.0.1
 */