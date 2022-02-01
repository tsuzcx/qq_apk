import java.util.ArrayList;

public abstract class bezo
  implements bezn
{
  protected abstract ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt)
  {
    if (paramInt == 2) {
      return paramArrayList1;
    }
    if (paramInt == 3) {
      return a(paramArrayList1, paramArrayList2);
    }
    return paramArrayList2;
  }
  
  protected ArrayList b(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localArrayList.add(paramArrayList1.get(0));
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
      localArrayList.addAll(paramArrayList2);
    }
    return localArrayList;
  }
  
  protected ArrayList c(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {
      localArrayList.addAll(paramArrayList2);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      localArrayList.add(paramArrayList1.get(0));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezo
 * JD-Core Version:    0.7.0.1
 */