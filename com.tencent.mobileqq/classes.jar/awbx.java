public abstract class awbx
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final alxk dbHelper = build(paramString);
  private String mName;
  
  public awbx(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract alxk build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public awbw createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    awcj localawcj = new awcj(this.dbHelper, this.mName);
    this.closed = false;
    return localawcj;
  }
  
  public awbw createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    awce localawce = new awce(this.dbHelper, this.mName);
    this.closed = false;
    return localawce;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbx
 * JD-Core Version:    0.7.0.1
 */