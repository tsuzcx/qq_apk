import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bbdp
  implements bbem
{
  public bbdp(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, bbej parambbej) {}
  
  public void a(int paramInt, String paramString, ArrayList<bbej> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "getVideoListReq->onLoaded: retCode = " + paramInt);
    }
    if (paramInt == 0) {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = paramArrayList.iterator();
        paramInt = 0;
        if (paramString.hasNext())
        {
          paramArrayList = (bbej)paramString.next();
          if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.contains(paramArrayList)) {
            break label358;
          }
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
          paramInt = 1;
        }
      }
    }
    label358:
    for (;;)
    {
      break;
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Bbdw.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.d(2);
        return;
      }
      QLog.d("TribeVideoListPlayerFragment", 2, String.format("onLoadMore isEmpty, start:%d, bid:%d, pid%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Bbdw.getItemCount() + this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Bbej.b), this.jdField_a_of_type_Bbej.d }));
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.d(3);
      azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "page_repeat", this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e, 0, this.jdField_a_of_type_Bbej.b + "", this.jdField_a_of_type_Bbej.d, this.jdField_a_of_type_Bbej.h + "", "");
      return;
      QLog.d("TribeVideoListPlayerFragment", 2, String.format("onLoadMore isEmpty, start:%d, bid:%d, pid%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Bbdw.getItemCount() + this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Bbej.b), this.jdField_a_of_type_Bbej.d }));
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.d(3);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.d(4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdp
 * JD-Core Version:    0.7.0.1
 */