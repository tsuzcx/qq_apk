import com.tencent.ark.ark.PlayerStub;
import com.tencent.ark.ark.PlayerStubFactory;

final class appc
  implements ark.PlayerStubFactory
{
  public ark.PlayerStub CreateStub()
  {
    return new appb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appc
 * JD-Core Version:    0.7.0.1
 */