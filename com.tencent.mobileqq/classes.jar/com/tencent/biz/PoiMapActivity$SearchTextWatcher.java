package com.tencent.biz;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.widget.XListView;
import java.util.List;

public class PoiMapActivity$SearchTextWatcher
  implements TextWatcher
{
  protected PoiMapActivity$SearchTextWatcher(PoiMapActivity paramPoiMapActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.z.getText().toString().trim();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.a.A.setVisibility(8);
      this.a.E.setVisibility(8);
      this.a.K.clear();
      this.a.L.notifyDataSetChanged();
      return;
    }
    this.a.A.setVisibility(0);
    this.a.a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */