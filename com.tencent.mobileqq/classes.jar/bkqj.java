import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;

class bkqj
  implements bhuw
{
  private bkqj(bkqg parambkqg) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_Bkqd.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name))) {
      QQToast.a(this.a.getActivity(), 2131690067, 0).a();
    }
    boolean bool;
    do
    {
      return;
      bool = this.a.jdField_a_of_type_Bkqw.a(paramAdapterView, paramInt, paramView);
    } while (this.a.jdField_a_of_type_Bkqk == null);
    this.a.jdField_a_of_type_Bkqk.a(paramAdapterView, paramInt, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqj
 * JD-Core Version:    0.7.0.1
 */