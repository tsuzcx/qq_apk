public abstract class atmq
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final ajrl dbHelper = build(paramString);
  private String mName;
  
  public atmq(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract ajrl build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public atmp createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    atnc localatnc = new atnc(this.dbHelper, this.mName);
    this.closed = false;
    return localatnc;
  }
  
  public atmp createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    atmx localatmx = new atmx(this.dbHelper, this.mName);
    this.closed = false;
    return localatmx;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmq
 * JD-Core Version:    0.7.0.1
 */