import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

class amiy
  extends anvi
{
  amiy(amiw paramamiw) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_Amii != null) && ((this.a.jdField_a_of_type_Amii instanceof amij))) {
        ((amij)this.a.jdField_a_of_type_Amii).a(paramString);
      }
      amiw.a(this.a);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      amiw.a(this.a);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushAdd isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      amiw.a(this.a);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushDel isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      amiw.a(this.a);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.notifyDataSetChanged();
      if (amiw.a(this.a) != null)
      {
        amiw.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        amiw.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amiy
 * JD-Core Version:    0.7.0.1
 */