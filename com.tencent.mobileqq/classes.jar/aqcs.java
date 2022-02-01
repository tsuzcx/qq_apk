import com.tencent.ark.ark.PlayerStub;
import com.tencent.ark.ark.PlayerStubFactory;

final class aqcs
  implements ark.PlayerStubFactory
{
  public ark.PlayerStub CreateStub()
  {
    return new aqcr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcs
 * JD-Core Version:    0.7.0.1
 */