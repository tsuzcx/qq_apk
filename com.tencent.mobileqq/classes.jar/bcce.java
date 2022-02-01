import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem;

public final class bcce
  implements Parcelable.Creator<AssociateSearchWordsFragment.AssociateItem>
{
  public AssociateSearchWordsFragment.AssociateItem a(Parcel paramParcel)
  {
    return new AssociateSearchWordsFragment.AssociateItem(paramParcel);
  }
  
  public AssociateSearchWordsFragment.AssociateItem[] a(int paramInt)
  {
    return new AssociateSearchWordsFragment.AssociateItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcce
 * JD-Core Version:    0.7.0.1
 */