import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;

public class bhhh
{
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(paramInt);
    paramArrayList.add(localActionSheetItem);
    return localActionSheetItem;
  }
  
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, String paramString, int paramInt2)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = a(paramInt1, paramArrayList);
    paramArrayList = paramString;
    if (paramString == null) {
      paramArrayList = "";
    }
    localActionSheetItem.argus = paramArrayList;
    localActionSheetItem.firstLineCount = paramInt2;
    return localActionSheetItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhh
 * JD-Core Version:    0.7.0.1
 */