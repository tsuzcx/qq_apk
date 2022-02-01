package com.tencent.luggage.game.widget.input;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.luggage.wxa.pp.aa;

class WAGamePanelInputEditText$1
  extends Editable.Factory
{
  WAGamePanelInputEditText$1(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    return WAGamePanelInputEditText.a(this.a).a((Editable)WAGamePanelInputEditText.a(this.a, super.newEditable(paramCharSequence)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.WAGamePanelInputEditText.1
 * JD-Core Version:    0.7.0.1
 */