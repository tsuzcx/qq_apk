import android.text.Editable;
import android.text.TextWatcher;
import dov.com.tencent.biz.qqstory.takevideo.poilist.SearchPoiListLayout;

public class aomc
  implements TextWatcher
{
  public aomc(SearchPoiListLayout paramSearchPoiListLayout) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    SearchPoiListLayout.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomc
 * JD-Core Version:    0.7.0.1
 */