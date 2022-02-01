import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class baei
{
  protected int a;
  protected PublishVideoEntry a;
  protected int b;
  protected int c;
  protected int d = -1;
  protected int e = -1;
  
  public baei(int paramInt, PublishVideoEntry paramPublishVideoEntry)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = new PublishVideoEntry();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.copy(paramPublishVideoEntry);
    a(this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode);
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 7: 
      return 5;
    case 8: 
      return 6;
    case 9: 
      return 7;
    }
    return 4;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public void a(int paramInt)
  {
    this.b = b(paramInt);
    this.c = a(paramInt);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baei
 * JD-Core Version:    0.7.0.1
 */